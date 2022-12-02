package com.example.applicationwith3activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applicationwith3activity.databinding.ActivityMainBinding
import com.example.applicationwith3activity.databinding.ActivityMainFirstFragmentBinding

class MainFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainFirstFragmentBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainFirstFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}