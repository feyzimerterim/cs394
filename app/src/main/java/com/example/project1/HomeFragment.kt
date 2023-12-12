package com.example.project1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        recyclerView = view.findViewById(R.id.myRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = ItemAdapter(emptyList()) // Initialize with empty list
        recyclerView.adapter = adapter

        // Observe ViewModel LiveData and update UI accordingly
        viewModel.itemData.observe(viewLifecycleOwner) { data ->
            adapter.updateData(data) // Update adapter data
        }

    }


}