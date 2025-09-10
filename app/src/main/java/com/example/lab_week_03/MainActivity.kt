package com.example.lab_week_03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), CoffeeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply window insets to the FragmentContainerView root
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Add initial ListFragment when activity starts (only once)
        if (savedInstanceState == null) {
            findViewById<FragmentContainerView>(R.id.fragment_container).let { containerLayout ->
                val listFragment = ListFragment()
                supportFragmentManager.beginTransaction()
                    .add(containerLayout.id, listFragment)
                    .commit()
            }
        }
    }

    // Called from ListFragment through CoffeeListener
    override fun onSelected(id: Int) {
        findViewById<FragmentContainerView>(R.id.fragment_container).let { containerLayout ->
            val detailFragment = DetailFragment.newInstance(id)
            supportFragmentManager.beginTransaction()
                .replace(containerLayout.id, detailFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}
