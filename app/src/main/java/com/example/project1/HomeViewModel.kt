package com.example.project1


import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeViewModel : ViewModel() , RecyclerViewInterface {
    private val _itemData = MutableLiveData<List<ItemModel>>()
    val itemData: LiveData<List<ItemModel>> = _itemData
    private val itemsList = mutableListOf<ItemModel>()
    init {
        fetchData()
    }

    private lateinit var supportFragmentManager: FragmentManager
    private fun fetchData() {
        val database: DatabaseReference = Firebase.database.reference


        database.child("Items").get().addOnSuccessListener { dataSnapshot ->


            for (itemSnapshot in dataSnapshot.children) {
                val item = itemSnapshot.getValue(ItemModel::class.java)
                item?.let { itemsList.add(it) }
            }
            _itemData.value = itemsList
        }.addOnFailureListener {
        }

    }
    override fun onItemClick(position: Int) {
        val itemDetailFragment = ItemDetailFragment()

        val bundle = Bundle()
        bundle.putString("itemName", itemsList[position].itemName)
        bundle.putString("itemDescription", itemsList[position].itemDescription)
        bundle.putInt("itemPrice", itemsList[position].itemPrice)
        itemDetailFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, itemDetailFragment)
            .addToBackStack(null)
            .commit()
    }
}