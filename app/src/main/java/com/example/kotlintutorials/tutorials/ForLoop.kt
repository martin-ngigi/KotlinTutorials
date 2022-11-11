package com.example.kotlintutorials.tutorials

fun main(){
    println("First For Loop\nPrint the entire array")// Print the entire array
    val myArray= arrayOf(2,4,6,1)
    for (i in myArray){
        println(i)
    }


    println("\nSecond For Loop\nFrom 1 to 5.... ie range")
    for (i in 1..5){//from 1 to 5.... ie range
        println(i)
    }

    println("\nThird Loop\nStart from 10 all the way to 5")
    for (i in 10 downTo 5){//start from 10 all the way to 5
        println(i)
    }

    println("\nFourth loop\nStart from 10 all the way to 5. Skip two number")
    for (i in 10 downTo 5 step 2){//skip two number
        println(i)
    }

    println("\nFifth For Loop\nPrint all alphabets from a-Z")
    for (i in 'a'..'z'){
        println(i)
    }

    println("\n The maximum Number in the array")
    var myArr = arrayOf(3,5,3,77,6,2)
    var max = myArr[0]//initialize the array
    for (item in myArr){
        if (item > max){// we have found the item
            //now set the item to the found one
            max = item
        }
    }
    println("Max is: $max")
}