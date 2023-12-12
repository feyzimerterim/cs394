package com.example.project1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class ItemRecyclerViewAdapter(
    private val context: Context,
    private val itemsModel: ArrayList<ItemModel>,
    private val recyclerViewInterface: RecyclerViewInterface
) : RecyclerView.Adapter<ItemRecyclerViewAdapter.MyViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recycler_view_row, parent, false)
        return MyViewHolder(view, recyclerViewInterface)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewName.text = itemsModel[position].itemName
        holder.textViewPrice.text = itemsModel[position].itemPrice.toString()
        holder.textViewDescription.text = itemsModel[position].itemDescription
    }

    override fun getItemCount(): Int {
        return itemsModel.size
    }

    inner class MyViewHolder(itemView: View, recyclerViewInterface: RecyclerViewInterface) :
        RecyclerView.ViewHolder(itemView) {
        var textViewPrice: TextView = itemView.findViewById(R.id.textView2)
        var textViewName: TextView = itemView.findViewById(R.id.textView1)
        var textViewDescription: TextView = itemView.findViewById(R.id.textView3)

        init {
            itemView.setOnClickListener {
                if (recyclerViewInterface != null) {
                    val pos = adapterPosition
                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos)
                    }
                }
            }
        }
    }
}
