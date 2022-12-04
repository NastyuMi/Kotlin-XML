package com.example.applicationwith3activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
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
            {
                binding.gender.text = "you`re superwoman"
            } else
            {
                binding.gender.text = "you`re superman"
            }

        }

        binding.button3.setOnClickListener {
            /*val userData = intent.getParcelableExtra<UserData>("userData")
            Intent(this,FirstFragment::class.java).apply {
                putExtra("userData",userData)
            }*/
            binding.button2.isEnabled = false
            binding.button3.isEnabled = false
            binding.fragment.alpha = 1F
        }

        binding.fragment.alpha = 0F

        binding.button2.setOnClickListener(::buttonClick)

    }

    private fun buttonClick(v: View) {
        val userData = intent.getParcelableExtra<UserData>("userData")
        startActivity(Intent(this,MainFragmentActivity::class.java).apply {
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