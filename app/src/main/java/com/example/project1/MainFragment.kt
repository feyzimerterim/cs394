package com.example.project1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.project1.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.buttonLogin.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
        }
        binding.buttonSignUp.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_signupFragment)
        }



    }
}