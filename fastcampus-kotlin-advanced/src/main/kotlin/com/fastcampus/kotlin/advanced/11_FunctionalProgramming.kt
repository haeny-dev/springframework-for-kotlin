package com.fastcampus.kotlin.advanced

fun main() {

    val list = mutableListOf(printHello)

    // val func: () -> Unit = list[0]
    // func()

    call(printHello)

    // 컴파일 에러
    // list.add(printNo)
    // val func = printNo

    val result = plus(1, 3, 5)
    println(result)

    val strList = listOf("a", "b", "c")
    val printStr: (String) -> Unit = { println(it) }
    forEachStr(strList, printStr)

    // 후행 람다 전달
    forEachStr(strList) {
        println(it)
    }

    strList.forEach(printStr)

    val upperCase: (String) -> String = { it.uppercase() }
    println(strList.map(upperCase))

    val func = outerFunc()
    func()

    arg1 {
        it.length
        it.first()
    }

    arg2 { a, b ->
        a.length
        b.first()
    }

    // val callReference: () -> Unit = { printHello() }
    val callReference = ::printHello
    callReference()()

    val numbers = listOf("1", "2", "3")
    numbers.map { it.toInt() }.forEach { println(it) }
    numbers.map(String::toInt).forEach(::println)
}

// val func: () -> Unit = {}

val printHello: () -> Unit = { println("Hello") }

val printMessage: (String) -> Unit = { message: String -> println(message) }
val printMessage2: (String) -> Unit = { message -> println(message) }
val printMessage3: (String) -> Unit = { println(it) }

val plus: (Int, Int, Int) -> Int = { a, b, c -> a + b + c }

// 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block()
}

fun printNo() = println("No")

/**
 * 고차함수
 */
fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}

fun arg1(block: (String) -> Unit) {}

fun arg2(block: (String, String) -> Unit) {}

/**
 * 익명함수
 */
// fun outerFunc(): () -> Unit {
//     return fun() {
//         println("이것은 익명함수")
//     }
// }

// fun outerFunc(): () -> Unit {
//     return {
//         println("이것은 익명함수")
//     }
// }

fun outerFunc(): () -> Unit = { println("이것은 익명함수") }

// 람다 표현식 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

// 최대한 생략한 식
val sum2 = { x: Int, y: Int -> x + y }


