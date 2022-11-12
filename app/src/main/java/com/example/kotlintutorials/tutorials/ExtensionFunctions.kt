package com.example.kotlintutorials.tutorials

fun main(){
    println("Enter a number:")
    var input = readLine()?.toInt()

    if (input != null){
        if (input.isPrime()){
            println("$input is a prime number")
        }
        else{
            println("$input is not a prime number")
        }
    }
}

//Int.isPrime is the extended function
//Boolean is the return type
fun Int.isPrime(): Boolean{
    for (i in 2 until this - 1){ //"this" is the input
        if (this % i == 0){
            return false
        }
    }
    return true
}
