package com.example.kotlintutorials
fun main(){
    println("Hello World... Its Wainaina doing Kotlin")

    var myVariable: Int = 5 //var means variable... ie, can be changed later as it varies
    println(myVariable)

    //Above is the same as
    var myVar = 4
    println(myVar)
    myVar = 6
    //print the variable inside a string using "$" character
    println("My Second Variable after changing it is : $myVar")

    val myVal = 7 //val means value... it can't be changed after initialization
    println("Value is: $myVal ")

    //Booleans
    var myBoo: Boolean = true
    //the above boolean is same as
    var myBoolean = true
    println("MyBoolean is $myBoolean")

}