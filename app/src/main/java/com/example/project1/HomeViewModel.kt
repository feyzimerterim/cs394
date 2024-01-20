package com.example.project1

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class HomeViewModel : ViewModel() {

    private val itemInformation = MutableLiveData<List<ItemModel>>()
    private val itemsList = mutableListOf<ItemModel>()

    val itemData: LiveData<List<ItemModel>> = itemInformation


    private val _navigateToItemDetail = MutableLiveData<ItemModel>()
    val navigateToItemDetail: LiveData<ItemModel>
        get() = _navigateToItemDetail


    init {
        getData()
    }

    private lateinit var navController: NavController

    fun setNavController(controller: NavController) {
        navController = controller
    }



    fun onItemClick(position: Int) {
        val itemDetailFragment = ItemdetailFragment()


        val bundle = Bundle()
        bundle.putString("itemName", itemsList[position].itemName)
        bundle.putString("itemDescription", itemsList[position].itemDescription)
        bundle.putDouble("itemPrice", itemsList[position].itemPrice)
        itemDetailFragment.arguments = bundle


        navController.navigate(R.id.action_homeFragment_to_itemDetailFragment, bundle)
    }


    private fun getData() {
        val database: DatabaseReference = Firebase.database.reference

        database.child("Items").get().addOnSuccessListener { dataSnapshot ->

            for (itemSnapshot in dataSnapshot.children) {
                val item = itemSnapshot.getValue(ItemModel::class.java)
                item?.let { itemsList.add(it) }
            }
            itemInformation.value = itemsList
        }.addOnFailureListener {
        }
    }
}
