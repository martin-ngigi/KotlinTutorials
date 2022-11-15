package com.example.kotlintutorials.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintutorials.R
import com.example.kotlintutorials.services.MyService
import kotlinx.android.synthetic.main.activity_services2.*

class Services2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services2)

        btn_start_service2.setOnClickListener {
            Intent(this@Services2Activity, MyService::class.java).also {
                //check log.d() in MyService
                startService(it)
                tv_serviceStatus2.text = "Service Running..."
            }
        }

        btn_stop_service2.setOnClickListener {
            Intent(this@Services2Activity, MyService::class.java).also {
                //check log.d() in MyService
                stopService(it)
                tv_serviceStatus2.text = "Service Stopped"
            }
        }

        btn_send2.setOnClickListener {
            Intent(this@Services2Activity, MyService::class.java).also {
                val dataString = edt_data2.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
                //clear data
                edt_data2.setText("")

            }
        }

    }
}