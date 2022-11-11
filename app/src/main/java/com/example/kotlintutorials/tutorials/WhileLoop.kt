package com.example.kotlintutorials.tutorials

fun main(){
    var x = 0
    //This pront hello as long as x is less than 3
    while (x<3){
        println("hello $x")
        x++ //increment by 1 ... same as x=x+1,,,, same as x+=1

    }

    println()
    var myArray = arrayOf("Hello", "Guys", "It,s", "Martin", "Again")
    var i=0
    while (i<myArray.size){
        println(myArray[i])
        i++ //increment i by 1
    }

    //calculate of sum from 1 to 5
    var j =0
    var sum =0
    while (j<5){
        sum += j
        j++
    }
    println("\nSum is: $sum")
}