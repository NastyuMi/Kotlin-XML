package com.example.applicationwith3activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationwith3activity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentUserData = intent.getParcelableExtra<UserData>("userData")
        intentUserData?.let {
            binding.textView3.text="${it.name}"
            if( it.man == true)
                binding.gender.text="you`re superwoman"
            else
                binding.gender.text="you`re superman"
        }

        binding.button2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("AppWith3act", "onSaveInstanceState Call")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("AppWith3act","onSaveInstanceState")
        outState.apply {
            putString("userData",binding.gender.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("AppWith3act", "onRestoreInstanceState Call")
        savedInstanceState.run{
            binding.gender.text = getString("userData")
        }
    }

}