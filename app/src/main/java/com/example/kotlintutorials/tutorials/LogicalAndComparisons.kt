package com.example.kotlintutorials.tutorials

fun main(){
    var a =20
    var b = 5
    println("is $a equal to $b ${a==b}")
    println("is a==b and is a>b ? ${(a==b)&&(a<b)}")

    //negating
    println("\nNegating the answer.\nIs $a equal to $b ?${!(a==b)}")

    //in instance where there is || and &&. the && is always executed first
}