package com.example.kotlintutorials.tutorials.classes

class Circle(var radius: Double) { //"()" is the contructor
    //init is always called whren const is created
    init {
        println("Circle created with radius : $radius")
    }

    var pi = 3.141592

    fun area() = radius*radius*pi

    fun parameter() = 2*radius*pi
}