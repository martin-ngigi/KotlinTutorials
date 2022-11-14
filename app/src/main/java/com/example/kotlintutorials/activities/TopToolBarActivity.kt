package com.example.kotlintutorials.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.kotlintutorials.R

class TopToolBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_tool_bar)
    }

    //inflate the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    //handle on click listener for the menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mi_addContact -> Toast.makeText(this@TopToolBarActivity, "You clicked Contacts", Toast.LENGTH_SHORT).show()
            R.id.mi_favourite -> Toast.makeText(this@TopToolBarActivity, "You clicked Favourites", Toast.LENGTH_SHORT).show()
            R.id.mi_settings -> Toast.makeText(this@TopToolBarActivity, "You clicked Settings", Toast.LENGTH_SHORT).show()
            R.id.mi_close -> {
                Toast.makeText(this@TopToolBarActivity, "You clicked Close App", Toast.LENGTH_SHORT).show()
                finish()
            }
            R.id.mi_feedback -> Toast.makeText(this@TopToolBarActivity, "You clicked Feedback", Toast.LENGTH_SHORT).show()

        }
        return true
    }

}