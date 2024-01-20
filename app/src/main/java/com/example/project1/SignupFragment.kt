// SignupFragment.kt

package com.example.project1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.project1.databinding.FragmentSignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupFragment : Fragment(R.layout.fragment_signup) {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var viewModel: SignupViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignupBinding.bind(view)
        viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)

        binding.btnSignup.setOnClickListener {
            val email = binding.editTextEmail2.text.toString()
            val password = binding.editTextPassword2.text.toString()

            viewModel.signup(email, password)
        }

        viewModel.signupResult.observe(viewLifecycleOwner) { result ->
            if (result) {
                findNavController().navigate(R.id.action_signupFragment_to_mainFragment)
            } else {
            }
        }
    }
}
