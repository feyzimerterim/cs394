package com.example.project1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var view1: RecyclerView
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view1 = view.findViewById(R.id.myRecyclerView)
        view1.layoutManager = LinearLayoutManager(context)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        itemAdapter = ItemAdapter(viewModel)
        view1.adapter = itemAdapter

        viewModel.itemData.observe(viewLifecycleOwner) { data ->
            itemAdapter.submitList(data)
        }
        viewModel.setNavController(findNavController())

    }
}
