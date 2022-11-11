package com.example.kotlintutorials.tutorials

fun main(){
    var x=6
    var y = 6
    var z= if(7+7==14) 4 else 7 //
    /** same as :
    if(7+7==14){
        z=4
    }
    else{
        z=7
    }
    */


    if (x<y || 7*7==49)
        println("At least one condition is true")
    else if(x>y)
        println("$x is greater than $y")
    else
        println("$x is equal to $y")


    println("the value of z is $z")
}