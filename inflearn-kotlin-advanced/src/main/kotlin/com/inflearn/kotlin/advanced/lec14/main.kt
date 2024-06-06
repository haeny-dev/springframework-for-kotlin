package com.inflearn.kotlin.advanced.lec14

fun main() {
    compute(5, 3) { num1, num2 -> num1 + num2}

    var num = 5
    num += 1
    val plusOne: () -> Unit = { num += 1 }
}

// 함수를 변수처럼 사용할 때마다 FunctionN 객체가 만들어진다.
fun compute(num1: Int, num2: Int, op: (Int, Int) -> Int): Int {
    return op(num1, num2)
}

/**
 * - 고차함수를 사용하게 되면 FunctionN 클래스가 만들어지고 인스턴스화 되어야 하므로 오버헤드가 발생할 수 있다.
 * - 함수에서 변수를 포획할 경우, 해당 변수를 Ref 라는 객체로 감싸야 한다. 때문에 오버헤드가 발생할 수 있다.
 */