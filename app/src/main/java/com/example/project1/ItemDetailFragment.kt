package com.example.project1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ItemDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.item_detail,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("itemName")
        val price = arguments?.getString("itemPrice")
        val description = arguments?.getString("itemDescription")

        val nameTextView = view.findViewById<TextView>(R.id.textView1)
        val priceTextView = view.findViewById<TextView>(R.id.textView2)

        nameTextView.text = name
        priceTextView.text = price

    }
}
