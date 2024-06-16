package com.inflearn.kotlin.advanced.lec24

import kotlin.system.measureTimeMillis

fun main() {
    repeat(3) {
        println("Hello World")
    }

//    TODO("main 함수 구현")
//
//    measureTimeMillis {
//        // function
//    }

    val result: Result<Int> = runCatching { 1 / 0 }

}

fun acceptOnlyTwo(num: Int) {
    require(num == 2) { "2만 허용" }

    if (num != 2) {
        throw IllegalArgumentException("2만 허용")
    }
}

class Person {
    val status: PersonStatus = PersonStatus.PLAYING

    fun sleep() {
        check(this.status == PersonStatus.PLAYING) { "에러 메세지" }

        if (this.status != PersonStatus.PLAYING) {
            throw IllegalStateException()
        }
    }

    enum class PersonStatus {
        PLAYING, SLEEPING
    }
}