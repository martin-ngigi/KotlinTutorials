package com.example.kotlintutorials.tutorials

fun main(){
    println("enter your input..")
    var userInput = readLine()
    println("You entered ${userInput?.uppercase()}") //The ? firsts checks whether input is null or not.


    println("Enter any number")
    var num = readLine()

    if ((num != null) ) {
        println("You entered number $num")
        println("$num - 5 is: ${num.toInt()-5}") // num.toInt() converts the string to Integer
    }

}