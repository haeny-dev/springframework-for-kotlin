package com.haeny.lec06.kotlin

fun main() {

    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println("number = $number")
    }

    /**
     * .. 연산자: 범위를 만들어 내는 연산자
     * IntProgression <- IntRange
     * (등차수열)
     *
     * downTo, step <- 중위 호출 함수
     * 변수.함수이름(argument) 대신 변수 함수이름 argument 로 호출
     *
     * 1..5 step 2
     * 1) 1 부터 5 까지 공차가 1인 등차수열 생성
     * 2) 등차수열에 대한 함수 호출, 등차수열.step(2)
     * 3) 1 부터 5 까지 공차가 2인 등차수열이 반환
     */
    for (i in 1..3) {
        println(i)
    }

    for (i in 3 downTo 1) {
        println(i)
    }

    for (i in 1..5 step 2) {
        println(i)
    }

    var i = 1;
    while (i <= 3) {
        println(i)
        i++
    }
}
