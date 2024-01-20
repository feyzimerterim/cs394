package com.example.project1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.project1.databinding.ItemModelBinding


class ItemAdapter(private val viewModel: HomeViewModel) : ListAdapter<ItemModel, ItemAdapter.ItemViewHolder>(ItemDiffCallback()) {

    class ItemViewHolder private constructor(val binding: ItemModelBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemModelBinding.inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding)
            }
        }

        val itemName: TextView = binding.itemName
        val itemPrice: TextView = binding.itemPrice

        fun bind(item: ItemModel) {
            itemName.text = item.itemName
            itemPrice.text = item.itemPrice.toString()

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            viewModel.onItemClick(position)
        }
    }

    private class ItemDiffCallback : DiffUtil.ItemCallback<ItemModel>() {
        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }
    }
}
