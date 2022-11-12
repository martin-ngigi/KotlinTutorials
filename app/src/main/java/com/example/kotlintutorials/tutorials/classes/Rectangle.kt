package com.example.kotlintutorials.tutorials.classes

class Rectangle(var a: Double, var b: Double) { //"()" is the constructor
    //whenever the constructor is created, init will be called
    init {
        println("This rectangle has been created with a = $a and  b= $b")
    }

    fun area() = a*b

    fun parameter() = 2*(a+b)

    fun isSquare() = a==b
}