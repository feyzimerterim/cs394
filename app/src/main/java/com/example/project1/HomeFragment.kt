package com.example.project1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment(R.layout.fragment_home)   {
    private lateinit var itemAdapter: ItemAdapter

    private lateinit var view1: RecyclerView
    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        view1 = view.findViewById(R.id.myRecyclerView)
        view1.layoutManager = LinearLayoutManager(context)
        itemAdapter = ItemAdapter(emptyList())
        view1.adapter = itemAdapter

        viewModel.itemData.observe(viewLifecycleOwner) { data ->
            itemAdapter.updateData(data)
        }

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}

