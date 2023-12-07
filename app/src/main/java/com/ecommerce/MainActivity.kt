package com.ecommerce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ecommerce.Fragments.HomeFragment
import com.ecommerce.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.bottom_home -> openFragment(HomeFragment(), "Inicio")
            }
            true
        }
        fragmentManager = supportFragmentManager
        openFragment(HomeFragment(), "Inicio")
    }

    private fun openFragment(fragment: Fragment, s: String){
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fcv_main, fragment)
        fragmentTransaction.commit()
        setTitle(title)
    }

    private fun setTitle(title: String) {
        supportActionBar?.title = title
    }
}