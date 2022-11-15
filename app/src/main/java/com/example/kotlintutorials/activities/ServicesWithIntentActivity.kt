package com.example.kotlintutorials.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintutorials.R
import com.example.kotlintutorials.services.MyIntentService
import kotlinx.android.synthetic.main.activity_services_with_intent.*

class ServicesWithIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services_with_intent)

        btn_start_service.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                //check log.d() in MyIntentService
                startService(it)
                tv_serviceStatus.text = "Service is running"
            }
        }

        btn_stop_service.setOnClickListener {
            //check log.d() in MyIntentService
            MyIntentService.stopService()
            tv_serviceStatus.text = "Serviced stopped"
        }


    }
}