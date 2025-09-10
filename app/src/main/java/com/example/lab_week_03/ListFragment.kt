package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private var listener: CoffeeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_list, container, false)

        val affogato: TextView = root.findViewById(R.id.affogato)
        val americano: TextView = root.findViewById(R.id.americano)
        val latte: TextView = root.findViewById(R.id.latte)

        affogato.setOnClickListener { listener?.onSelected(R.id.affogato) }
        americano.setOnClickListener { listener?.onSelected(R.id.americano) }
        latte.setOnClickListener { listener?.onSelected(R.id.latte) }

        return root
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
