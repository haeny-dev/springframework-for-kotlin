package com.fastcampus.kotlin.advanced.scope_function

/**
 * with
 * - 결과 반환 없이 내부에서 수신객체를 통해 다른 함수를 호출하고 싶을 때
 */

fun main() {

    val str = "안녕하세요"

    with(str) {
        println("length = $length")
    }
}