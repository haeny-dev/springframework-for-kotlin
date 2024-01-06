package com.haeny.lec14.kotlin

fun main() {
    val dto1 = PersonDto("정주현", 100)
    val dto2 = PersonDto("정주현", 100)

    println(dto1 == dto2)
    println(dto1)
}

data class PersonDto(
    val name: String,
    val age: Int,
) {
}