package com.example.project1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginViewModel : ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _userEmail = MutableLiveData<String>()
    val userEmail: LiveData<String>
        get() = _userEmail

    private val auth = FirebaseAuth.getInstance()

    fun loginUser(callback: (Boolean, String?) -> Unit) {
        val enteredEmail = email.value ?: ""
        val enteredPassword = password.value ?: ""

        if (enteredEmail.isNotEmpty() && enteredPassword.isNotEmpty()) {
            auth.signInWithEmailAndPassword(enteredEmail, enteredPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user: FirebaseUser? = auth.currentUser
                        user?.let {
                            _userEmail.value = enteredEmail
                            callback(true, "Login successful")
                        }
                    } else {
                        callback(false, "Incorrect email or password")
                    }
                }
        } else {
            callback(false, "Email and password cannot be empty")
        }
    }
}
