package com.example.kotlintutorials.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlintutorials.R
import com.example.kotlintutorials.adapters.AdapterViewPager
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

        //set orientation
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //slide automatically
        viewPager.beginFakeDrag()
        viewPager.fakeDragBy(-10f) //"-" will move to left
        viewPager.endFakeDrag()

    }
}