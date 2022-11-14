package com.example.kotlintutorials.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintutorials.R
import kotlinx.android.synthetic.main.activity_change_image.*

class ChangeImageActivity : AppCompatActivity() {
    val IMAGE_INTENT = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_image)


        //get image from  files
        btn_change_picture.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*" //* means will look for every type of image
                startActivityForResult(it, IMAGE_INTENT)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode ==  Activity.RESULT_OK && requestCode == IMAGE_INTENT){
            val uri = data?.data
            iV_picture.setImageURI(uri)
        }
    }
}