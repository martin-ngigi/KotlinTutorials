package com.example.kotlintutorials

import java.io.Serializable

data class Person (
    val fullName: String,
    val age: Int
): Serializable //Serializable means we want to be able to pass this object between activities