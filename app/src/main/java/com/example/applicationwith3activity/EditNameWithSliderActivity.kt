package com.example.applicationwith3activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationwith3activity.databinding.ActivityEditNameWithSliderBinding
import com.ncorti.slidetoact.SlideToActView

class EditNameWithSliderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditNameWithSliderBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityEditNameWithSliderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.slider.onSlideCompleteListener = object: SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete (view: SlideToActView) {
                val userName = binding.editTextPersonName.text.toString()
                val userGender = binding.switchManWoman.isChecked
                val userData = UserData(userName, userGender)
                startActivity(Intent(this@EditNameWithSliderActivity,RestartOrNextActivity::class.java).apply{
                    putExtra("userData",userData)
                })
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
                binding.textAboveSlider.setText("if you`re $s swipe below\uD83D\uDC47\uD83C\uDFFC")

            }


        })

    }
}


