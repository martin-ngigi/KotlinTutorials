package com.example.kotlintutorials.tutorials.classes
//"(var name: String)" is the constructor
//"open" means that this class can be inherited
open class Shape(var name: String) {
    //init is always called
    init {
        println("I am the super class")
    }

    fun  changeName(newName: String){
        name = newName
    }
}