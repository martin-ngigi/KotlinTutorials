package com.example.kotlintutorials.tutorials.classes

fun main(){
    var list = (1..20).toList()
    println(list)

    //filter function
    //it is the current number/item
    //if it is an even number, keep it in the list
    //get all even numbers
    list = list.filter { it% 2 ==0 }
    println(list)

    //get all even  numbers greater the 7
    println()
    list = list.filter { it>8 }
    println(list)

}