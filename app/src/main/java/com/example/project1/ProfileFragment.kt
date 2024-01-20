package com.example.project1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.project1.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by viewModels()

    private val loginViewModel: LoginViewModel by viewModels({ requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentProfileBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_profile, container, false
        )

        binding.viewModel = profileViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        loginViewModel.userEmail.observe(viewLifecycleOwner, Observer { userEmail ->
            profileViewModel.setUserEmail(userEmail)
            Log.d("ProfileFragment", "User email observed: $userEmail")
        })

        profileViewModel.userEmail.observe(viewLifecycleOwner) { userEmail ->
            binding.userEmailTextView.text = userEmail
        }

        return binding.root
    }
}
