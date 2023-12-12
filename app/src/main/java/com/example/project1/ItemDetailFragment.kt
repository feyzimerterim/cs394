package com.example.project1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ItemDetailFragment : Fragment() {

    private var itemName: TextView? = null
    private var itemDescription: TextView? = null
    private var itemPrice: TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.item_detail, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setValuesToViews()
    }

    private fun initView(view: View) {
        itemName = view.findViewById(R.id.textView1)
        itemPrice = view.findViewById(R.id.textView2)
        itemDescription = view.findViewById(R.id.textView3)

    }

    private fun setValuesToViews() {
        itemName?.text = arguments?.getString("name")
        itemPrice?.text = arguments?.getString("price")
        itemDescription?.text = arguments?.getString("description")

    }
}
