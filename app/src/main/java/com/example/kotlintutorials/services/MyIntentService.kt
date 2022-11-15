package com.example.kotlintutorials.services

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService: IntentService("MyIntentService") {
    /**
     * This service will run in seperate thread. so it wont block the main thread
     * But it wont support multithreading
     */

    init {
        instance = this
    }
    
    companion object{
        private lateinit var instance: MyIntentService
        var isRunning = false
        
        fun stopService(){
            Log.d("MyIntentService", "Service is stopping... ")
            isRunning = false
            instance.stopSelf()
        }
    }
    
    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning=true
            while (isRunning){
                Log.d("MyIntentService", "Service is running... ")
                Thread.sleep(1000)//sleep for 1 second
            }
        }
        catch (e: InterruptedException){
            Thread.currentThread().interrupt()
        }
    }

}