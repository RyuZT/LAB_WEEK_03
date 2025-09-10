package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private var titleView: TextView? = null
    private var descView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // bind views
        titleView = view.findViewById(R.id.coffee_title)
        descView = view.findViewById(R.id.coffee_desc)

        // read argument and update UI
        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(coffeeId)
    }

    fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                titleView?.text = getString(R.string.affogato_title)
                descView?.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                titleView?.text = getString(R.string.americano_title)
                descView?.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                titleView?.text = getString(R.string.latte_title)
                descView?.text = getString(R.string.latte_desc)
            }
            else -> {
                titleView?.text = ""
                descView?.text = ""
            }
        }
    }

    companion object {
        private const val COFFEE_ID = "COFFEE_ID"
        fun newInstance(coffeeId: Int): DetailFragment =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(COFFEE_ID, coffeeId)
                }
            }
    }
}
