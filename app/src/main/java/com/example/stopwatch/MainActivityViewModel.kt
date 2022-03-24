package com.example.stopwatch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel: ViewModel() {
    val time= MutableLiveData(Time())
    val lapTime= MutableLiveData<Time>()
    var timer:Timer?=null
    inner class StopWatchTimer:TimerTask(){
        override fun run() {
            time.value?.increment()
            time.postValue(time.value?:Time())
        }
    }
    fun startTimer(){
        if (timer==null) {
            timer = Timer()
            timer?.scheduleAtFixedRate(StopWatchTimer(), 1000, 1000)
        }
    }
    fun pauseTimer(){
        timer?.cancel()
        timer=null
    }
    fun stopTimer(){
        pauseTimer()
        time.value?.reset()
        time.postValue(time.value)
    }
    fun lap(){
        lapTime.postValue(time.value)
    }
    fun clearLap(){
        lapTime.postValue(Time())
    }
}