package com.rave.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.rave.rickandmortyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView4) as NavHostFragment
        navController = navHostFragment.navController


    }
}