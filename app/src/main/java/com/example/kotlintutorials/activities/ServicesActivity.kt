package com.example.kotlintutorials.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintutorials.R
import com.example.kotlintutorials.services.MyIntentService
import kotlinx.android.synthetic.main.activity_services.*

class ServicesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        btn_start_service.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                tv_serviceStatus.text = "Service is running"
            }
        }

        btn_stop_service.setOnClickListener {
            MyIntentService.stopService()
            tv_serviceStatus.text = "Serviced stopped"
        }


    }
}