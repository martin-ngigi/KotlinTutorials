package com.example.kotlintutorials.tutorials

fun main(){
    println("Enter your age")
    var age = readLine()?.toInt()


    if (age in 0..5){ //if age=>0 && age<=5
        println("you are a young kid")
    }
    else if ( age in 5..17){//else if age=>5 && age<=17
        println("You are a teenager")
    }
    else if ( age == 18){//else if age==18
        println("Finally you are a 18")
    }
    else if ( age == 19 || age == 20){//
        println("You are a young adult")
    }
    else if ( age in 21..65){//else if age=>21 && age<=65
        println("You are an adult")
    }
    else{
        println("You are really old.")
    }

    //ABOVE IF STATEMENTS CAN BE REPLACED WITH:
    when(age){
        in 0..5 -> println("you are a young kid")
        in 5..17 -> println("You are a teenager")
        18 -> println("Finally you are a 18")
        19, 20 -> println("You are a young adult")
        in 21..65 -> println("You are an adult")
        else -> println("You are really old.")
    }
}