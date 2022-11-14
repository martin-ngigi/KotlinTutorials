package com.example.kotlintutorials.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintutorials.R
import com.example.kotlintutorials.fragments.FirstFragment
import com.example.kotlintutorials.fragments.SecondFragment
import kotlinx.android.synthetic.main.activity_fragmentes_example.*

class FragmentesExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentes_example)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        //set initial fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, firstFragment)
            commit() //app;y changes
        }

        //handle btnFragment1 on click listener
        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, firstFragment) //replace fl_fragment with firstFragment
                addToBackStack(null)//ad it to stack so that if i click back, it will take me to previous fragment/activity
                commit() //app;y changes
            }
        }

        //handle btnFragment2 on click listener
        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, secondFragment) //replace fl_fragment with secondFragment
                addToBackStack(null)//ad it to stack so that if i click back, it will take me to previous fragment/activity
                commit() //app;y changes
            }
        }
    }
}