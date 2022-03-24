package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.activity.viewModels
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
        val pauseButton = binding.buttonPause
        val lapButton = binding.buttonLap
        val lapClearButton = binding.buttonLapClear
        val viewModel:MainActivityViewModel by viewModels()
        startButton.setOnClickListener {
            viewModel.startTimer()
        }
        stopButton.setOnClickListener {
            viewModel.stopTimer()
        }
        pauseButton.setOnClickListener {
            viewModel.pauseTimer()
        }
        lapButton.setOnClickListener {
            viewModel.lap()
        }
        lapClearButton.setOnClickListener {
            viewModel.clearLap()
        }
        viewModel.time.observe(this){
            textViewTime.text=it.toString()
        }
        viewModel.lapTime.observe(this){
            textViewLapTime.text=it.toString()
        }

    }
}