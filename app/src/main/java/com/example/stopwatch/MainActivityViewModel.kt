package com.example.stopwatch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    val time= MutableLiveData<Time>()
    val lapTime= MutableLiveData<Time>()
}