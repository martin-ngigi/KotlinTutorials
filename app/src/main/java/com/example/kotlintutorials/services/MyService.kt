package com.example.kotlintutorials.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    /**
     * This service will run in main thread.
     *  it will support multithreading
     */

    val TAG = "MyService"


    init {
        Log.d(TAG, "Service is running... ")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return  null
    }

    /**
     * Used to deliver the intent we started the service with.
     * We can also pass data from activity to this service
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString =  intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG, "Data: ${dataString}")
        }

        Thread{
            while (true){}
        }.start()

        return START_STICKY
    }

    override fun onDestroy() {
        Log.d(TAG, "Service is stopping... ")
        super.onDestroy()
    }
}