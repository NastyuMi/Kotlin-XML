package com.example.applicationwith3activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ncorti.slidetoact.SlideToActView

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        //val sta = findViewById<View>(R.id.slider) as SlideToActView

    }
}


