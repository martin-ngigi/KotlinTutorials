package com.example.kotlintutorials.tutorials.classes
//"(var name: String)" is the constructor
//"open" means that this class can be inherited
//open class Shape(var name: String) {

abstract class Shape(var name: String) {
    //init is always called
    init {
        println("I am the super class")
    }

    constructor(name: String, vararg dimensions: Double): this(name)

    //abstract classes are common in child classes
    //abstract classes created. They will be implemented later to those classes that will inherit this
    //abstract classed are created whenever we don't know what these methods will do, but we know there must be these classes ... ie rect and circle have different implementations but must have area and perimeter classes
    abstract fun area(): Double

    abstract fun perimeter(): Double

    fun  changeName(newName: String){
        name = newName
    }
}