package com.example.kotlintutorials.tutorials

fun main(){
    printPow(2,4)
}

fun printPow(base: Int, exponent: Int){
    var result = 1
    for ( i in 1..exponent ){
        result *= base //same as result = result * base
    }
    println("$base to power $exponent is $result")
}