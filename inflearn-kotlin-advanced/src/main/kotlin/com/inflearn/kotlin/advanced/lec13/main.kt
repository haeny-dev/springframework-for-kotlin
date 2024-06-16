package com.inflearn.kotlin.advanced.lec13

/**
 * 고차함수
 * - 파라미터로 함수를 받거나 함수를 반환하는 함수
 *
 * 아래와 같은 람다식, 익명 함수를 함숫값 or 함수 리터럴이라고 한다.
 *
 * 람다 -> (프로그래밍 용어) 이름이 없는 함수
 *
 * 람다식 -> (코틀린 용어) 함숫값 / 함수 리터럴을 표현하는 방법1
 * 익명 함수 -> (코틀린 용어) 함숫값 / 함수 리터럴을 표현하는 방법2
 *
 * 람다식 vs 익명 함수
 */

fun main() {
    // 람다식
    // 반환 타입을 적을 수 없다.
    // return 키워드 쓸 수 없다.
    compute(5, 3) { a, b -> a + b }

    // 익명함수
    // 반환 타입을 적을 수 있다.
    // return 키워드 쓸 수 있다.
    compute(5, 3, fun(a: Int, b: Int) = a + b)

    iterate(listOf(1, 2, 3, 4, 5), fun(num) {
        if (num == 3) {
            return
        }
        println(num)
    })

    iterate(listOf(1, 2, 3, 4, 5)) { num ->
        if (num == 3) {
//            return    // Error
        }
        println(num)
    }
}

// 마지막 파라미터의 람다식은 함수 호출부 바깥으로 꺼낼 수 있다.
// 함수 파라미터에 default parameter 사용 가능
fun compute(num1: Int, num2: Int, op: (Int, Int) -> Int): Int {
    return op(num1, num2)
}

fun iterate(numbers: List<Int>, exec: (Int) -> Unit) {
    for (number in numbers) {
        exec(number)
    }
}

fun calculate(num1: Int, num2: Int, oper: Operator) = oper.calcFun(num1, num2)

enum class Operator(
    private val oper: Char,
    val calcFun: (Int, Int) -> Int,
) {
    PLUS('+', { a, b -> a + b }),
    MINUS('-', { a, b -> a - b }),
    MULTIPLY('*', { a, b -> a * b }),
    DIVIDE('/', { a, b ->
        if (b == 0) {
            throw IllegalArgumentException("0 으로 나눌 수 없습니다.")
        } else {
            a / b
        }
    })
}
