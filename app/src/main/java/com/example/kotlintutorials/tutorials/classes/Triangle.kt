package com.example.kotlintutorials.tutorials.classes

import kotlin.math.sqrt

class Triangle(var a: Double, var b: Double,
               var c: Double): Shape("Triangle"){

    init {
        println("I am the super class")
        println("This $name has been created with a = $a and  b= $b")
        println("$name  created area  : ${area()}")
        println("$name  created perimeter : ${perimeter()}")

    }

    override fun area() = sqrt((perimeter()/2) * (perimeter()/2-a) * (perimeter()/2-b) * (perimeter()/2-c) )

    override fun perimeter() = a+b+c
}