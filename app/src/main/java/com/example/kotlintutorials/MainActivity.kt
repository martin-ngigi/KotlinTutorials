package com.example.kotlintutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*


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

        //handle btn_add when clicked
        btn_add.setOnClickListener {
            //check if inputs are empty or not
            if ((!edt_firstNumber.text.toString().isEmpty()) && (!edt_secondNumber.text.toString().isEmpty())){
                //get Text from the view
                val firstNumber = edt_firstNumber.text.toString().toInt() // The "?" checks if null or not. The ".toInt()" converts from string to integer
                val secondNumber = edt_secondNumber.text.toString().toInt()

                //set text to the view
                tv_sum.text = "${firstNumber+secondNumber}"

            }
        }

        //handle btn_change_image when clicked
        btn_change_image.setOnClickListener {
            //change the image
            iV_image_android.setImageResource(R.drawable.android2)
        }

        //handle btn_order when clicked
        btn_order.setOnClickListener {
            //check what user has checked in the radio button group
            val checkedMeatRadioButtonId = rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)

            //should return true or false
            val cheese = cbCheese.isChecked
            val onions = cbOnions.isChecked
            val salad = cbSalad.isChecked

            val orderString = "You ordered a bugger with:\n"+
                    "${meat.text}\n"+
                    (if (cheese) "\nCheese" else "")+ //if true.. answer is cheese else its empty
                    (if (onions) "\nOnions" else "")+
                    (if (salad) "\nSalad" else "")

            //set to UI
            tv_order.text = orderString
        }

        //handle btn_toast when clicked
        btn_toast.setOnClickListener {
            //Toast.makeText(this, "This is my toast", Toast.LENGTH_SHORT).show()

            //Custom made toast with UI...
            Toast(this).apply {
                duration = Toast.LENGTH_LONG
                //"Gravity.END,Gravity.END" Will make the bar appear at the bottom... but can be changed to "0,0"
                setGravity(Gravity.FILL_HORIZONTAL, Gravity.END,Gravity.END)
                view = layoutInflater.inflate(R.layout.custom_toast, layout_custom_toast)
                show()
            }

        }

        //handle btn_openSecond when clicked
        btn_openSecond.setOnClickListener {
            //open second activity

            //check if edit texts are empty
            if (edt_full_name.text.isEmpty() || edt_age.text.isEmpty()){
                Toast.makeText(this, "Full Name and Age cant be empty", Toast.LENGTH_SHORT).show()
            }
            else{

                //get data from ui
                val full_name = edt_full_name.text.toString()
                val age = edt_age.text.toString().toInt()

                //use person object to pass data
                val person = Person(full_name, age)

                //"Intent(this, SecondActivity::class.java)" will create an instance of intent
                //"also {startActivity(it) }" will start the activity
                Intent(this, SecondActivity::class.java).also {
                    //put extra will set the data that is to be passed to the next activity
                    it.putExtra("Extra_full_Name", full_name)
                    it.putExtra("Extra_age", age)
                    //pass data inform of object
                    it.putExtra("Extra_Person", person)
                    startActivity(it) //it refers to the instance of intent
                }
            }

        }
    }
}