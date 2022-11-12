package com.example.kotlintutorials.tutorials.classes

//"(var a: Double, var b: Double)" is the constructor
//"Shape("Rectangle")" means we are inheriting the Shape and passing "Rectangle" as our shapeName
class Rectangle(var a: Double, var b: Double): Shape("Rectangle") {
    //whenever the constructor is created, init will be called
    init {
        //$name has been inherited from Shape class
        println("This $name has been created with a = $a and  b= $b")
    }

    //INCASE THESE ABSTRACT CLASSES ARE NOT
    //IMPLEMENTED, PRESS Ctrl + o to implement them automatically ;-)


    //override the area from superclass
    override fun area() = a*b

    //override the perimeter from superclass
    override fun perimeter() = 2*(a+b)

    fun isSquare() = a==b
}