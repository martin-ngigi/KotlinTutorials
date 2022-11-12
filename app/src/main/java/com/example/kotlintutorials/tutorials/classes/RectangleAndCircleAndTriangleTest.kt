package com.example.kotlintutorials.tutorials.classes

fun  main(){
    //create an instance of the rectangle
    var myRec = Rectangle(5.0, 4.0)

    println("Rectangle : $myRec")
    //println("Rectangle are is : ${myRec.area()}")
    //println("Rectangle perimeter is : ${myRec.perimeter()}")
    //println("Rectangle is a square : ${myRec.isSquare()}")

    var rect2 = Rectangle(2,4) //create a rectangle with int params
    //println("\nRectangle 2 of type int. Area is : ${rect2.area()}")
    println("\nRectangle2 : $rect2")

    var rect3 = Rectangle(5.0) //create a rectangle which is a square in shape
    //println("\nRectangle 3 is a square and. Area is : ${rect3.area()}")
    println("\nRectangle3 : $rect3")

    //create an instance of circle with radius 5
    println()
    var circle = Circle(5.0)
    circle.changeName("CIRCLE")//change circle name
    //println("Circle name is now ${circle.name}")
    //println("Circle are is : ${circle.area()}")
    //println("Circle perimeter is : ${circle.perimeter()}")
    println("\nCircle 1: $circle")

    //create another instance of circle with radius 7
    var circle2 = Circle(7.0)
    //println("\nCircle2 are is : ${circle2.area()}")
    //println("Circle2 perimeter is : ${circle2.perimeter()}")
    println("\nCircle 2 $circle2")

    //method overloading example
    var crc = Circle(8.0)
    var rct = Rectangle(4.0, 7.0)
    var trg = Triangle(3.0,7.0,9.0)
    var maxAreaRectAndCircle = maxArea(crc, rct)
    var maxAreaRectAndCircleTriangle = maxArea(rct, rct, trg)
    println("\nMaximum area of circle and rectangle is : $maxAreaRectAndCircle")
    println("Maximum area of circle and rectangle and triangle is : $maxAreaRectAndCircleTriangle")


    //testing companion object... No need to create instance object since instance is already created in Random object
    val circleRandom = Circle.randomCircle()
}

//Overloading methods
//This method has two params but same method name and return type
fun maxArea(shape1: Shape, shape2: Shape): Double{
    var areaShape1 = shape1.area()
    var areaShape2 = shape2.area()
    return if(areaShape1>areaShape2) areaShape1 else areaShape2
}
//This method has three params but same method name and return type
fun maxArea(shape1: Shape, shape2: Shape, shape3: Shape): Double{
    //get max area from maxArea() method above and assign it to maxAreaShape1Shape2
    var maxAreaShape1Shape2 = maxArea(shape1, shape2)
    var areaShape3 = shape3.area()
    return if (maxAreaShape1Shape2>areaShape3) maxAreaShape1Shape2 else areaShape3
}
