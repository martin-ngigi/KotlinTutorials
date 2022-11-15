package com.example.kotlintutorials.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintutorials.R
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        //modes to save pref
        //1. Public - any other app can access
        //2. private - no other app can access the pref
        //3. append - it wont replace the existing preference but will append the new pref

        val sharedPreference = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit() //edit the preference

        //handle btn_save click listener
        btn_save.setOnClickListener {
            //get data from ui
            val name = edt_name.text.toString()
            val age = edt_age.text.toString().toInt()
            val isAdult = cb_isAdult.isChecked

            //save data in shared preference
            editor.apply {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply() // save
            }
        }

        //handle btn_load click listener
        btn_load.setOnClickListener {
            //load data from shared preference
            val name = sharedPreference.getString("name", null) //"name" is the stored key name, null is the default valuable in case name doesn't exist
            val age = sharedPreference.getInt("age", 0)//"age" is the stored key name, 0 is the default valuable in case name doesn't exist
            val isAdult = sharedPreference.getBoolean("isAdult", false)//"isAdult" is the stored key name, false is the default valuable in case name doesn't exist

            //set the data to the UI
            edt_name.setText(name)
            edt_age.setText(age.toString())
            cb_isAdult.isChecked = isAdult
        }
    }
}