package com.example.kotlintutorials.tutorials

fun main(){
    //1.VARARG
    //var max = getMax(listOf(4,6,2,4))
    var max = getMax(4,6,2,4)
    println("Max Number is $max")

    var arrayToBeAdded = intArrayOf(33,7,44)
    var max2 = getMax(4,6, *arrayToBeAdded,2,4)
    println("Max Number in array 2  is $max2")

    //2.DEFAULT PARAMETERS
    searchFor("How to become a good developer")//here, since we have not added the search engine... Google will be added by default
    searchFor("How to become the best kotlin programmer", "Bing")

    //NAMED PARAMETERS
    //Its not a must to put the parameters in the right order
    searchFor(searchEngine = "DuckDuckGO", search = "How to become the best kotlin programmer")
}

//fun getMax(lis: List<Int>) : Int{
//same as one above
fun getMax(vararg numbers: Int): Int{
    var max = numbers[0]
    for (number in numbers){
        if (number>max){
            max=number
        }
    }
    return max
}

fun searchFor(search: String, searchEngine: String="Google"){
    println("Search for $search on $searchEngine")
}