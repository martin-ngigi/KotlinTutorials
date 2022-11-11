package com.example.kotlintutorials

fun main(){
    //sum
    var x = 7
    var y = 8
    var sum = x+y
    println("1. Sum of $x and $y is ${x+y}") //use ${} to include the entire adding statement
    x+=10 //sane as x=x+10
    println("2. Sum of $x and $y is now ${x+y}") //use ${} to include the entire adding statement

    //divisions
    println("\nDividing using integers:\n20/8="+20/8+"\nThis gives the whole numbers and excludes the decimals. ")
    var a = 20.0
    var b = 7.0
    var quotient= a/b
    println("\nDividing doubles:\n$a / $b = $quotient")
}