package com.haeny.lec08.kotlin

import com.haeny.lec08.java.Lec08Main

fun main() {
    repeat("Hello World")
    repeat("Hello World", 3, false)
    /**
     * named argument
     */
    repeat("Hello World", useNewLine = false)

    // 값이 서로 변경되어도 지장 없음
    printNameAndGender("FEMALE", "정주현")

    // Builder 를 사용하는 것과 같은 이점을 누릴 수 있다.
    printNameAndGender(name = "정주현", gender = "MALE")

    // 코틀린에서 자바 함수를 가져다 사용할 때는 named argument를 사용할 수 없다.
//    Lec08Main.repeat(str = "A")

    printAll("A", "B", "C")

    val array = arrayOf("A", "B", "C")
    printAll(*array) // 배열을 바로 넣는 대신 스프레드 인자를 써야한다.
}

fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}

/**
 * 1) public <- 접근 지시어, public 은 생략 가능
 * 2) if-else 는 expression 으로 만듬
 * 3) 함수가 하나의 결과값이면 block 대신 `=` 사용 가능
 * 4) 반환 값이 a 혹은 b 이기 때문에 반환타입 추론이 가능하여 반환타입 생략 가능
 *    - 타입이 생략가능한 이유는 `=` 를 사용했기 때문
 *    - {} block 를 사용하는 경우 반환타입이 Unit 아닌 경우 타입을 명시해주어야 함
 * 5) if-else 의 중괄호도 간단한 경우 생략 가능
 *
 * - 함수는 클래스 안에 있을 수도 있고,
 * - 파일 최상단에 있을 수도 있고,
 * - 또한 한 파일 안에 여러 함수들이 있을 수도 있다.
 */
fun max(a: Int, b: Int) = if (a > b) a else b

/**
 * default parameter
 */
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true){
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}