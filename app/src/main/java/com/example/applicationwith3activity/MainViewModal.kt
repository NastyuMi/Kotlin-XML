package com.example.applicationwith3activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModal(app: Application) : AndroidViewModel(app) {
    var textUpDate = MutableLiveData<Int>()
    var count : Int = 0

    fun start(){
        viewModelScope.launch {
            startCount()
        }
    }

    private suspend fun startCount(){
        for(i in (0..count).reversed() ) {
            textUpDate.postValue(i)
            delay(500)
        }
    }
}