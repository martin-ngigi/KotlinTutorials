package com.example.kotlintutorials.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.kotlintutorials.R
import kotlinx.android.synthetic.main.activity_navigation_drawer.*

class NavigationDrawerActivity : AppCompatActivity() {

    //toggle button to open the h=nav
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        //initialize
        //open and close strings are used by the blind people, incase they open, produces sound
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()//ready to be used

        //open toggle , create a back arrow, when arrow is clicked, close the toggle again
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //respond to menu on click listener
        navView.setNavigationItemSelectedListener {
            //it is the current item that was selected
            when(it.itemId){
                R.id.mi_nav_addContact -> {
                  Toast.makeText(this@NavigationDrawerActivity, "You clicked Contact", Toast.LENGTH_SHORT).show()
                }
                R.id.mi_nav_favourite -> {
                    Toast.makeText(this@NavigationDrawerActivity, "You clicked Favourite", Toast.LENGTH_SHORT).show()
                }
                R.id.mi_nav_home-> {
                    Toast.makeText(this@NavigationDrawerActivity, "You clicked Home", Toast.LENGTH_SHORT).show()
                }
                R.id.mi_nav_messages -> {
                    Toast.makeText(this@NavigationDrawerActivity, "You clicked Messages", Toast.LENGTH_SHORT).show()
                }
            }
            true //returns true to the click
        }
    }

    //handle click listener for the toggle
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}