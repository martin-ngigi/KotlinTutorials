package com.example.kotlintutorials.tutorials.classes

//"(var a: Double, var b: Double)" is the constructor
//"Shape("Rectangle")" means we are inheriting the Shape and passing "Rectangle" as our shapeName
class Rectangle(var a: Double, var b: Double): Shape("Rectangle") {
    //whenever the constructor is created, init will be called
    init {
        //$name has been inherited from Shape class
        println("This $name has been created with a = $a and  b= $b")
    }

    fun area() = a*b

    fun parameter() = 2*(a+b)

    fun isSquare() = a==b
}