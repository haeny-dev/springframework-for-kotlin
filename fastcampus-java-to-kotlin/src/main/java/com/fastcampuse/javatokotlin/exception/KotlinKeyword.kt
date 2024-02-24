package com.fastcampuse.javatokotlin.exception

enum class CountryCodeKotlin {
    kr, jp, us, `do`;
}

fun main() {
    val javaKeyword = JavaKeyword()

    // 예약어의 경우에는 ` 문자로 이스케이스 해서 사용
    javaKeyword.`in`
    javaKeyword.`is`
}