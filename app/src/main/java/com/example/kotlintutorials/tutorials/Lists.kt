package com.example.kotlintutorials.tutorials

fun main(){
    /**
     * Difference between array and lists is that, arrays can be changed during runtime
     * where as the lists can not be changed.
     */

    var array = arrayOf(3,5,7,2)
    var list = listOf(3,5,7,2)

    array[0] = 9
    //list[0]=9 //Can't be changed
    println("Index 0 of array is ${array[0]}")

    //To change the lists... use Mutable lists
    var mutableList = mutableListOf(3,5,7,2)
    mutableList[0] = 9
    println("Index 0 of mutable list is is ${mutableList[0]}")

    /**
     * The difference between array and mutable lists is
     * Mutable list length can change but array's length can not change
     */

    //adding element in list
    mutableList.add(5)
    println("\nMutable list after adding element 5 \n $mutableList")

    mutableList.remove(7)
    println("\nMutable list after removing element 7 \n $mutableList")

    mutableList.removeAt(1)
    println("\nMutable list after removing element in index 1 \n $mutableList")

    //allow the user to enter a list in the console
    println("\nEnter the list")
    var mylist = mutableListOf<Int>()
    for (i in 1..10){ //loop starts from 1 all the way to 10
        var x = readLine()?.toInt() //let the user to enter a number... The ? makes sure its not empty, .toInt converts string inputted to Integer
        if (x != null) { //input is not null
            mylist.add(x)//after inserting the value, add it to the list
        }
    }
    println("\nThe List is : $mylist")


}