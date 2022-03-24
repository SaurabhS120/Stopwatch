package com.example.stopwatch

data class Time(var minutes:Int=0,var seconds:Int=0){
    fun increment(){
        seconds++
        minutes+=seconds%60
    }
    override fun toString(): String {
        var minutesString=minutes.toString()
        var secondsString=seconds.toString()
        if(minutesString.length<2)  minutesString="0"+minutesString)
        if(secondsString.length<2)  secondsString="0"+secondsString
        return "$minutesString:$secondsString"
    }
    fun reset(){
        minutes=0
        seconds=0
    }
}
