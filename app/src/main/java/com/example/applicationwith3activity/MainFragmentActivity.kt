package com.example.applicationwith3activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.example.applicationwith3activity.databinding.ActivityMainFirstFragmentBinding

class MainFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainFirstFragmentBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainFirstFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragmentAVATARs.isActivated = false

        binding.buttonForSendAgeAndQuote.setOnClickListener {

            binding.fragmentAVATARs.isActivated =  true

            var name : String? = ""

            var age : String? = ""

            var quote : String? = ""

            val intentUserData = intent.getParcelableExtra<UserData>("userData")
            intentUserData?.let {
                name = "It is ${it.name}"
                if( it.man == true)
                {
                    age = "She is " + binding.editTextNumber.text.toString() + " y.o."
                    quote = "Her favorite quote: " + binding.editTextQuote.text.toString()
                } else
                {
                    age = "He is " + binding.editTextNumber.text.toString() + " y.o."
                    quote = "His favorite quote:  " + binding.editTextQuote.text.toString()
                }
            }

            val navHostFragment = binding.fragmentINFO.getFragment<NavHostFragment>()
            val firstTrans = navHostFragment.childFragmentManager.fragments[0] as OnlySplashScreenFragment
            firstTrans.childFragmentManager
                .setFragmentResult(
                    "main_data",
                    bundleOf("name" to name,
                        "age" to age,
                        "quote" to quote)
                )
        }
    }

}