package com.example.applicationwith3activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.applicationwith3activity.databinding.ActivityFirstBinding
import com.ncorti.slidetoact.SlideToActView
import kotlinx.coroutines.runBlocking

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.slider.onSlideCompleteListener = object: SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete (view: SlideToActView) {
                Toast.makeText(this@FirstActivity,"Hi, " + binding.editTextPersonName.text, Toast.LENGTH_LONG) .show()
            }
        }

        binding.editTextPersonName.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //binding.textView6.setText("enter name above☝\uD83C\uDFFC")

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //binding.textView6.setText("your name is $s?")
            }

            override fun afterTextChanged(s: Editable) {
                binding.textView6.setText("if you`re $s swipe below\uD83D\uDC47\uD83C\uDFFC")

            }


        })

    }
}


