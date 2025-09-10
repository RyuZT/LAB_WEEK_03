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
        } else {
            throw RuntimeException("Host activity must implement CoffeeListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_list, container, false)

        val affogato = root.findViewById<TextView>(R.id.affogato)
        val americano = root.findViewById<TextView>(R.id.americano)
        val latte = root.findViewById<TextView>(R.id.latte)

        affogato.setOnClickListener { listener?.onSelected(R.id.affogato) }
        americano.setOnClickListener { listener?.onSelected(R.id.americano) }
        latte.setOnClickListener { listener?.onSelected(R.id.latte) }

        return root
    }
}
