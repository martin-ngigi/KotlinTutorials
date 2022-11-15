package com.example.kotlintutorials.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlintutorials.R
import com.example.kotlintutorials.adapters.AdapterViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        //set images
        val images = listOf(
            R.drawable.android2,
            R.drawable.android3,
            R.drawable.android4,
            R.drawable.android_developer
        )

        //set adapter
        val adapter = AdapterViewPager(images)
        viewPager.adapter = adapter

        /**
        //set orientation
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //slide automatically
        viewPager.beginFakeDrag()
        viewPager.fakeDragBy(-10f) //"-" will move to left
        viewPager.endFakeDrag()
        */

        //Declare tab layout and set the view pager inside... but viewPager can be replaced with fragments
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = "Tab ${position+1}"
        }.attach()

        //handle tab select listener.
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPagerActivity, "Selected Tab ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPagerActivity, "UnSelected Tab ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPagerActivity, "ReSelected Tab ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

        })

    }
}