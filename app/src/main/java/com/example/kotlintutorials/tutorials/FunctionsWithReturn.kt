package com.example.kotlintutorials.tutorials

fun main(){
    var pow = printPowWithReturn(2,4)
    println("2 power 4 is $pow")

    println("2 * 3 is : ${multiply(2,3)}")

    var list = listOf(3,6,2)
    println("\nList : $list")
}

fun printPowWithReturn(base: Int, exponent: Int) : Int{ //The last Int is the return Type
    var result = 1
    for ( i in 1..exponent ){
        result *= base //same as result = result * base
    }
    return  result
}

//one line function
fun multiply(a:Int, b:Int) = a*b

//printing a list
fun printList(list: List<Int>){
    for (i in list){
        println(list[i])
    }
}