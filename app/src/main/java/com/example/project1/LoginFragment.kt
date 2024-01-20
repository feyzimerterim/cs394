package com.example.project1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.project1.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.viewModel = loginViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.loginButton.setOnClickListener {
            loginUser()
        }

        loginViewModel.email.observe(viewLifecycleOwner, Observer { userEmail ->

            Toast.makeText(requireContext(), "User Email: $userEmail", Toast.LENGTH_SHORT).show()
        })

        return binding.root
    }

    private fun loginUser() {
        loginViewModel.loginUser { isSuccess, message ->
            if (isSuccess) {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            } else {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }
    }
}
