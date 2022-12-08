package com.example.applicationwith3activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationwith3activity.databinding.ActivityRestartOrNextBinding

class RestartOrNextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestartOrNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityRestartOrNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentUserData = intent.getParcelableExtra<UserData>("userData")
        intentUserData?.let {
            binding.textNameSecondActivity.text="${it.name}"
            if( it.man == true)
            {
                binding.textGender.text = "you`re superwoman"
            } else
            {
                binding.textGender.text = "you`re superman"
            }

        }

        binding.buttonStartAgain.setOnClickListener {
            binding.buttonStartAgain.isEnabled = false
            binding.buttonGoToNext.isEnabled = false
            binding.fragment.alpha = 1F
        }

        binding.fragment.alpha = 0F

        binding.buttonGoToNext.setOnClickListener(::buttonClick)

    }

    private fun buttonClick(v: View) {
        val userData = intent.getParcelableExtra<UserData>("userData")
        startActivity(Intent(this,LoadingActivity::class.java).apply {
            putExtra("userData",userData)
        })

    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("AppWith3act", "onSaveInstanceState Call")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("AppWith3act","onSaveInstanceState")
        outState.apply {
            putString("userData",binding.textGender.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("AppWith3act", "onRestoreInstanceState Call")
        savedInstanceState.run{
            binding.textGender.text = getString("userData")
        }
    }

}