package com.example.project1


import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeViewModel : ViewModel()  {
    private val _itemData = MutableLiveData<List<ItemModel>>()
    val itemData: LiveData<List<ItemModel>> = _itemData

    private lateinit var firebaseRef : DatabaseReference
    init {
        fetchData()
    }

    private lateinit var supportFragmentManager: FragmentManager
    private fun fetchData() {
        val database: DatabaseReference = Firebase.database.reference
        firebaseRef=FirebaseDatabase.getInstance().getReference("Items")

        database.child("Items").get().addOnSuccessListener { dataSnapshot ->
            val itemsList = mutableListOf<ItemModel>()

            for (itemSnapshot in dataSnapshot.children) {
                val item = itemSnapshot.getValue(ItemModel::class.java)
                item?.let { itemsList.add(it) }
            }
            _itemData.value = itemsList
            Log.i("firebase", "Data fetched successfully")
        }.addOnFailureListener { exception ->
            Log.e("firebase", "Error getting data", exception)
        }
    }


}