package com.example.kotlintutorials.tutorials.classes

fun main(){
    val  a =3.0
    val b=4.0
    val height = 2.0
    val parallelogram = object : Shape("parallelogram",a,b,height){

       init {
           println("parallelogram created with a=$a and b=b$b and height=$height")
           println("Are is ${area()}")
           println("Perimeter is ${perimeter()}")
       }

        override fun area(): Double {
            return a*height
        }

        override fun perimeter(): Double {
            return 2*a+2*b
        }

        fun isRectangle(): Boolean = height==b

    }

    println("Is the parallelogram a rectangle ${parallelogram.isRectangle()}")
}