package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textViewTime = binding.textViewTime
        val textViewLapTime = binding.textViewLapTime
        val startButton = binding.buttonStart
        val stopButton = binding.buttonStop
        val flagButton = binding.buttonFlag
        val handler = object : Handler(){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                textViewTime.text = "00:"+msg.data.getString("seconds")
            }
        }
        class TimerThread:Thread() {
            var time = 0
            var stop = false
            override fun run() {
                super.run()
                while (true) {
                    if (stop) return
                    val msg = Message()
                    val bundle = Bundle()
                    var timeString = time.toString()
                    if(timeString.length<2){
                        timeString="0"+timeString
                    }
                    bundle.putString("seconds", timeString)
                    msg.data = bundle
                    handler.sendMessage(msg)
                    time++
                    sleep(1000)
                }
            }

            fun startTimer() {
                time = 0
                stop = false
                start()
            }

            fun stopTimer() {
                stop = true
            }
        }
        class Timer {
            var timerThread: TimerThread?=null
            fun startTimer() {
                if (timerThread==null) {
                    timerThread = TimerThread()
                }
                timerThread?.startTimer()
            }

            fun stopTimer() {
                timerThread?.stopTimer()
                timerThread=null
            }
        }
        val timer=Timer()
        startButton.setOnClickListener {
            timer.startTimer()
        }
        stopButton.setOnClickListener {
            timer.stopTimer()
        }
    }
}