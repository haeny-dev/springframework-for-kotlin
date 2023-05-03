package com.fastcampus.kotlin.basic

import java.lang.IllegalArgumentException

fun main() {
    Thread.sleep(1)

    try {
        Thread.sleep(1)
    } catch (e: Exception) {
        println("예외 발생")
    }

    try {
        throw Exception()
    } catch (e: Exception) {
        println("예외 발생!")
    } finally {
        println("finally 실행!")
    }

    // 코틀린에서는 try ~ catch 는 표현식
    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        println("예외 발생!")
    }

    println(a)

//    throw Exception("예외 발생!")

    val b: String? = null
    val c = b ?: failFast("a is null") // 엘비스 연산자와 Nothing 타입을 같이 사용하면 절대 nullable 한 결과가 나올 수 없다.

    println(c.length)

//    failFast("예외 발생!!")
//    println("이 메세지는 출력될까?")
}

fun failFast(message: String): Nothing {
    throw IllegalArgumentException(message)
}