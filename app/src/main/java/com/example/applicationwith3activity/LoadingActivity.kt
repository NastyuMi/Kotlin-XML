package com.example.applicationwith3activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.applicationwith3activity.R
import com.example.applicationwith3activity.databinding.ActivityLoadingBinding
import com.example.applicationwith3activity.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

class LoadingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoadingBinding
    private lateinit var viewModal : MainViewModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModal = ViewModelProvider(this)[MainViewModal::class.java]

        viewModal.count = 5

        viewModal.start()

        viewModal.textUpDate.observe(this){
            if (it == 0) {
                val userData = intent.getParcelableExtra<UserData>("userData")
                startActivity(Intent(this,MainFragmentActivity::class.java).apply {
                    putExtra("userData",userData)
                })
            }
            binding.testTimer.text = it.toString()
        }



    }
}