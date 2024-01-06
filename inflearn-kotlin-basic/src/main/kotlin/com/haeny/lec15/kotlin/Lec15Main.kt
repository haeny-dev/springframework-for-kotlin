package com.haeny.lec15.kotlin

fun main() {

    /* Array */
    var array = arrayOf(100, 200)
    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    array = array.plus(300)
    for ((idx, value) in array.withIndex()) {
        println("$idx $value")
    }

    /* List */
    val numbers = listOf(100, 200)  // 기본적으로 불변리스트

    val emptyList = emptyList<Int>()    // 비어있는 리스트인 경우 타입을 명시적으로 넣어줘야 한다.
    printNumbers(emptyList())   // 추론이 가능하면 생략이 가능하다.

    println(numbers[0])

    for (number in numbers) {
        println(number)
    }

    for ((i, v) in numbers.withIndex()) {
        println("$i $v")
    }

    val mutableNumbers = mutableListOf(100, 200) // 가변리스트 생성
    mutableNumbers.add(300)

    /* Set */
    // List와 동일

    /* Map */
    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    mapOf(1 to "MONDAY", 2 to "TUESDAY")

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }
}

private fun printNumbers(numbers: List<Int>) {}