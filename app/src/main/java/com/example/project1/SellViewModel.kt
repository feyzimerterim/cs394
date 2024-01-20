package com.example.project1

import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SellViewModel : ViewModel() {
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var ref: DatabaseReference = database.getReference("Items")

    fun saveItemInfo(itemModel: ItemModel) {
        val id = ref.push().key ?: return
        val itemRef = ref.child(id);

        itemRef.setValue(itemModel)
    }
}