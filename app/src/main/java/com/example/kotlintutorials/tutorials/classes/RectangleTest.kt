package com.example.kotlintutorials.tutorials.classes

fun  main(){
    //create an instance of the rectangle
    var myRec = Rectangle(5.0, 4.0)

    println("Rectangle are is : ${myRec.area()}")
    println("Rectangle perimeter is : ${myRec.parameter()}")
    println("Rectangle is a square : ${myRec.isSquare()}")


    //create an instance of circle with radius 5
    var circle = Circle(5.0)
    println("\nCircle are is : ${circle.area()}")
    println("Circle perimeter is : ${circle.parameter()}")

    //create another instance of circle with radius 7
    var circle2 = Circle(7.0)
    println("\nCircle2 are is : ${circle2.area()}")
    println("Circle2 perimeter is : ${circle2.parameter()}")

}