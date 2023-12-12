package com.example.project1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private var itemList: List<ItemModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView = view.findViewById(R.id.itemName)
        val itemPrice: TextView = view.findViewById(R.id.itemPrice)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemName.text = item.itemName // Assuming empSource is the source field in RideModel
        holder.itemPrice.text = item.itemPrice.toString() // Assuming empDestination is the destination field in RideModel
        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putString("name", item.itemName)
                putString("price", item.itemPrice.toString())
                putString("description", item.itemDescription)

            }
            holder.itemView.findNavController().navigate(R.id.action_homeFragment_to_itemDetailFragment, bundle)
        }  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return ItemViewHolder(view)

    }



    override fun getItemCount(): Int = itemList.size

    fun updateData(newList: List<ItemModel>) {
        itemList = newList
        notifyDataSetChanged()
    }
}
