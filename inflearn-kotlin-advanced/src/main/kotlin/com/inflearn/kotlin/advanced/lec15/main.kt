package com.inflearn.kotlin.advanced.lec15

/**
 * inline 함수
 * - 함수를 호출하는 쪽에 함수 본문을 붙여넣게 된다.
 * - inline 함수에서 알 수 없는 함수 파라미터의 경우에는 inline 할 수 없다.
 * - noinline 키워드를 붙이면 inline 되지 않는다.
 * - inline 은 인라이닝에만 관여하지 않는다. => non local return 을 허용한다.
 */

fun main() {
    repeat(2) { println("Hello World") }

    iterate(listOf(1, 2, 3, 4, 5)) { num ->
        if(num == 3) {
//            return    // crossinline 키워드에 의해서 금지된다
        }
        println(num)
    }
}

inline fun iterate(numbers: List<Int>, crossinline exec: (Int) -> Unit) {
    for (num in numbers) {
        exec(num)
    }
}

inline fun repeat(
    times: Int,
    noinline exec: () -> Unit
) {
    for (i in 1..times) {
        exec()
    }
}

// 인라인 프로퍼티
class Person(val name: String) {
    inline val uppercaseName: String
        get() = this.name.uppercase()
}
