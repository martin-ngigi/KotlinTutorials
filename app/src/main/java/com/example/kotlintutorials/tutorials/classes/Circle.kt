package com.example.kotlintutorials.tutorials.classes

//"(var radius: Double)" means the constructor
//"Shape("Circle")" means we are inheriting the Shape and passing "Circle" as our shapeName
class Circle(var radius: Double):Shape("Circle") {
    //init is always called when const is created
    init {
        //$name has been inherited from Shape class
        println("$name  created with radius : $radius")
    }

    var pi = 3.141592

    fun area() = radius*radius*pi

    fun parameter() = 2*radius*pi
}