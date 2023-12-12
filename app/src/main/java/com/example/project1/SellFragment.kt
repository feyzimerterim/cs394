package com.example.project1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

class SellFragment : Fragment() {
    private lateinit var viewModel: SellViewModel

    private lateinit var Name: EditText
    private lateinit var Price: EditText
    private lateinit var Description: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_sell, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SellViewModel::class.java]
        Name = view.findViewById(R.id.Name)
        Price = view.findViewById(R.id.Price)
        Description = view.findViewById(R.id.Description)

        view.findViewById<Button>(R.id.buttonSave).setOnClickListener {
            saveData()

        }
    }

    private fun saveData() {
        val name = Name.text.toString()
        val price = Price.text.toString()
        val description = Description.text.toString()

        if (name.isEmpty() || price.isEmpty() || description.isEmpty()) {
        } else {
            val itemModel = ItemModel(
                itemName = name,
                itemPrice = price.toInt(),
                itemDescription = description
            )

            viewModel.saveItemData(itemModel)
        }
    }

}

