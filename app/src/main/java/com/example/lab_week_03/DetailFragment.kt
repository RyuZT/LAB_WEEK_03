package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private lateinit var titleView: TextView
    private lateinit var descView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_detail, container, false)
        titleView = root.findViewById(R.id.coffee_title)
        descView = root.findViewById(R.id.coffee_desc)
        return root
    }

    fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                titleView.text = getString(R.string.affogato_title)
                descView.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                titleView.text = getString(R.string.americano_title)
                descView.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                titleView.text = getString(R.string.latte_title)
                descView.text = getString(R.string.latte_desc)
            }
        }
    }
}
