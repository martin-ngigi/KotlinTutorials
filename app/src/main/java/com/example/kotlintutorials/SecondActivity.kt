package com.example.kotlintutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //handle btn_back when clicked
        btn_back.setOnClickListener {
            //go to main activity
            //"Intent(this, SecondActivity::class.java)" will create an instance of intent
            //"also {startActivity(it) }" will start the activity
            Intent(this, MainActivity::class.java).also {
                startActivity(it) // //it refers to the instance of intent
            }
        }
    }
}