package com.example.kotlintutorials.tutorials.classes

import java.lang.NumberFormatException

fun main(){
    println("Enter a number")
    var input = try {
        readln().toInt()
    }
    catch (e: NumberFormatException){
        //if user didnt enter a number, make the input a zero
        0
    }
    finally {
        println("This is finally block and is always executed.")
    }

    println("You entered $input")

    //Own exception
    try {
        divide(5.0, 0.0)
    }
    catch (e: DivisionByZeroException){
        println(e.message)
    }
}

//own exception
class DivisionByZeroException: Exception("Can not divide by zero, please chose a different number.")

fun divide(a:Double, b: Double): Double{
    if (b==0.0){
        throw DivisionByZeroException()
    }
    return a/b
}