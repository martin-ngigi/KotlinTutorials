package com.example.kotlintutorials.tutorials.classes

import kotlin.math.PI
import kotlin.random.Random

//"(var radius: Double)" means the constructor
//"Shape("Circle")" means we are inheriting the Shape and passing "Circle" as our shapeName
class Circle(var radius: Double):Shape("Circle") {
    //init is always called when const is created
    init {
        //$name has been inherited from Shape class
        println("$name  created with radius : $radius")
        println("$name  created area  : ${area()}")
        println("$name  created perimeter : ${perimeter()}")
    }

    companion object {
        fun randomCircle(): Circle{
            //chose radius randomly
            val radius = Random.nextDouble(1.0, 10.0)
            return Circle(radius)
        }
    }


    //override the area from superclass
    override fun  area() = radius*radius* PI

    //override the perimeter from superclass
    override fun perimeter() = 2*radius* PI
}