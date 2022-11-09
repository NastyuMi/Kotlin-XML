package com.example.applicationwith3activity

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.example.applicationwith3activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val amimator: Animation = AnimationUtils.loadAnimation(this, R.anim.first_anim)
        binding.textView2.startAnimation(amimator)

        binding.button.setOnClickListener(::buttonClick)

        /*
        не уверенна, что оно корректно сработает
        хочется, чтобы при долгом нажатии на HI! повторилась анимация
        */
        binding.textView2.setOnLongClickListener (object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                binding.textView2.startAnimation(amimator)
                return true
            }
        })
    }

    private fun buttonClick(v: View) {
        Toast.makeText(this@MainActivity,"Thank you for click\n on new lab you can go to new activity♥", Toast.LENGTH_LONG) .show()
    }
}