package com.example.stopwatch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel: ViewModel() {
    val time= MutableLiveData<Time>()
    val lapTime= MutableLiveData<Time>()
    val timer=Timer()
    val timerTask=object :TimerTask(){
        override fun run() {
            time.value?.increment()

        }
    }
    fun startTimer(){
    }
}