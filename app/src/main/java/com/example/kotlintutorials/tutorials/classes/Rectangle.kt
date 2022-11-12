package com.example.kotlintutorials.tutorials.classes

//"(var a: Double, var b: Double)" is the constructor... This is the primary constructor
//"Shape("Rectangle")" means we are inheriting the Shape and passing "Rectangle" as our shapeName
class Rectangle(var a: Double, var b: Double): Shape("Rectangle") {
    //whenever the constructor is created, init will be called
    init {
        //$name has been inherited from Shape class
        println("This $name has been created with a = $a and  b= $b")
        println("$name  created area  : ${area()}")
        println("$name  created perimeter : ${perimeter()}")

    }

    //Secondary constructor
    //assume where we have a square, we only need only one side
    //"(a: Double)" means the constructor will have only one parameter
    //"this(a,a)" means we are calling the primary constructor and passing one parameter twice.. ie. matching the secondary constructor with the primary constructor
    constructor(a: Double): this(a,a)

    //Secondary constructor
    //creating a secondary constructor with a different parameter types
    //"(a:Int, b:Int)" means the constructor has two params of type int
    //"this(a.toDouble(), b.toDouble()" means we are calling the primary constructor ans passing two values so as to match it
    //"a.toDouble()" means we are casting ints to double so as to match with the primary constructor
    constructor(a:Int, b:Int): this(a.toDouble(), b.toDouble())

    //INCASE THESE ABSTRACT CLASSES ARE NOT
    //IMPLEMENTED, PRESS Ctrl + o to implement them automatically ;-)


    //override the area from superclass
    override fun area() = a*b

    //override the perimeter from superclass
    override fun perimeter() = 2*(a+b)

    fun isSquare() = a==b
}