package com.example.kotlintutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //handle btn_apply when clicked
        btn_apply.setOnClickListener{
            //get Text from the view
            val firstName = edt_firstname.text.toString()
            val lastName = edt_lastname.text.toString()
            val birthDate = edt_birth_date.text.toString()
            val country = edt_country.text.toString()

            Log.d(TAG, "onCreate: firstName: $firstName, lastName: $lastName, $birthDate: birthDate, country: $country")

            //set text to the view
            tv_results.text = "Your Results: firstName: $firstName, lastName: $lastName, $birthDate: birthDate, country: $country"
        }
    }
}