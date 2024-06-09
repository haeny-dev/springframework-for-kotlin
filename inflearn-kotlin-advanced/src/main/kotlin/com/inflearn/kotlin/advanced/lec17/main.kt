package com.inflearn.kotlin.advanced.lec17

import java.time.LocalDate

/**
 * 연산자 오버로딩
 * - operator 키워드
 * - 함수명과 함수 매개변수가 정해져있다.
 */

fun main() {
    var point = Point(20, -10)
    println(point.zeroPointSymmetry())
    println(-point)
    println(++point)

    // 2024-06-11
    LocalDate.of(2024, 6, 8).plusDays(3)

    LocalDate.of(2024, 6, 8) + Days(3)

    LocalDate.of(2024, 6, 8) + 3.d

    val list = mutableListOf("A", "B", "C")
    list += "D" // 복합대입연산자가 구현되어 있다! 바로 호출

    var list2 = listOf("A", "B", "C")
    list2 += "D"    // 복합대입연산자가 구현되어 있지 않고 var 라면, list2 = list2 + "D" 로 연산한다.
    // val 이라면 Error 발생


}

data class Point(
    val x: Int,
    val y: Int,
) {
    fun zeroPointSymmetry(): Point = Point(-x, -y)

    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }

    operator fun inc(): Point {
        return Point(x + 1, y + 1)
    }
}

data class Days(val day: Long)

val Int.d: Days
    get() = Days(this.toLong())

operator fun LocalDate.plus(days: Days): LocalDate {
    return this.plusDays(days.day)
}