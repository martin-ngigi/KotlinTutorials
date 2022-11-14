package com.example.kotlintutorials.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlintutorials.R
import com.example.kotlintutorials.fragments.FirstFragment
import com.example.kotlintutorials.fragments.SecondFragment
import com.example.kotlintutorials.fragments.ThirdFragment
import kotlinx.android.synthetic.main.activity_bottom_nav.*

class BottomNavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        //create fragment instances
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        //set current fragment as firstFragment
        setCurrentFragment(firstFragment)

        //handle click listener
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mi_home -> setCurrentFragment(firstFragment)
                R.id.mi_messages -> setCurrentFragment(secondFragment)
                R.id.mi_profile -> setCurrentFragment(thirdFragment)
            }
            true //returns true value
        }

        //sample of setting the number of messages in message icon
        bottomNavigationView.getOrCreateBadge(R.id.mi_messages).apply {
            number = 12 //number 12 is any number
            isVisible = true //show the number
        }


    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_Fragment, fragment) //replace fl_Fragment with fragment
            commit() //save changes
        }
}