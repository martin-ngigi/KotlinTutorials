package com.example.kotlintutorials

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Gravity
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.karumi.dexter.Dexter
import com.karumi.dexter.DexterBuilder
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*


class MainActivity : AppCompatActivity() {



    var TAG = "MainActivity"

    var IMAGE_INTENT = 5

    //for permissions purposes
    lateinit var dexter: DexterBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //handle btn_apply when clicked
        btn_apply.setOnClickListener{

            applyMethod()
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
            orders()
        }

        //handle btn_toast when clicked
        btn_toast.setOnClickListener {
            toastCustomMessage()
        }

        //handle btn_openSecond when clicked
        btn_openSecond.setOnClickListener {
            //open second activity
            openSecondActivity()
        }

        btn_requestPermission.setOnClickListener {
            //requestPermissions()
            checkPermissions()
        }

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

    private fun checkPermissions() {
        getPermission()
    }

    private fun getPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            dexter = Dexter.withContext(this)
                .withPermissions(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.ACCESS_BACKGROUND_LOCATION
                ).withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                        report.let {

                            if (report.areAllPermissionsGranted()) {
                                Toast.makeText(this@MainActivity, "Permissions Granted", Toast.LENGTH_SHORT).show()
                            } else {
                                AlertDialog.Builder(this@MainActivity, com.google.android.material.R.style.Theme_AppCompat_Dialog).apply {
                                    setMessage("please allow the required permissions")
                                        .setCancelable(false)
                                        .setPositiveButton("Settings") { _, _ ->
                                            val reqIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                                                .apply {
                                                    val uri = Uri.fromParts("package", packageName, null)
                                                    data = uri
                                                }
                                            resultLauncher.launch(reqIntent)
                                        }
                                    // setNegativeButton(R.string.cancel) { dialog, _ -> dialog.cancel() }
                                    val alert = this.create()
                                    alert.show()
                                }
                            }
                        }
                    }
                    override fun onPermissionRationaleShouldBeShown(permissions: List<PermissionRequest?>?, token: PermissionToken?) {
                        token?.continuePermissionRequest()
                    }
                }).withErrorListener{
                    Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
                }
        }
        dexter.check()
    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result -> dexter.check()
    }


    private fun applyMethod() {
        //get Text from the view
        val firstName = edt_firstname.text.toString()
        val lastName = edt_lastname.text.toString()
        val birthDate = edt_birth_date.text.toString()
        val country = edt_country.text.toString()

        Log.d(TAG, "onCreate: firstName: $firstName, lastName: $lastName, $birthDate: birthDate, country: $country")

        //set text to the view
        tv_results.text = "Your Results: firstName: $firstName, lastName: $lastName, $birthDate: birthDate, country: $country"

    }

    private fun orders() {
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

    private fun toastCustomMessage() {
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

    private fun openSecondActivity() {
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

    /*
    private fun hasWritExtraStoragePermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForegroundPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationBackgroundPermission() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED


    private fun requestPermissions(){
        //request the user to allow permissions

        //if user has not permitted the permission, add the permission to the list as list
        var permissionToRequest = mutableListOf<String>()
        if (!hasWritExtraStoragePermission()){
            permissionToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (!hasLocationForegroundPermission()) {
            permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if (!hasLocationBackgroundPermission()) {
            permissionToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        //retrieve all the permissions not permitted from the list and transform them to array of string
        if (permissionToRequest.isNotEmpty()){
            ActivityCompat.requestPermissions(this, permissionToRequest.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()){
            //traverse the array of all the permissions required using for loo[
            for (i in grantResults.indices){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "onRequestPermissionsResult\n${permissions[i]} granted ;-)", Toast.LENGTH_LONG).show()
                    Log.d("RequestPermissions", "onRequestPermissionsResult:\n ${permissions[i]} granted ;-) ")
                }
            }
        }
    }
    */
}