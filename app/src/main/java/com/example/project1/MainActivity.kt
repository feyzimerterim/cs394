package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import com.example.project1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
         binding.bottomNavigationView.setOnItemSelectedListener {
             when(it.itemId) {
                 R.id.home->replaceFragment(HomeFragment())
                 R.id.basket->replaceFragment(Basket())
                 R.id.profile->replaceFragment(Profile())
                 else ->{

                 }
             }
    true
         }

    }

    private fun replaceFragment(fragment:Fragment) {
        val fragmentStateManager=supportFragmentManager
        val fragmentTransaction = fragmentStateManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

}

