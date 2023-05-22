package com.vanegas1.parcial.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vanegas1.parcial.R
import com.vanegas1.parcial.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}