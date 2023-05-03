package com.fastcampus.kotlin.advanced

/**
 * 확장 함수
 * - 확장이 되는 대상의 클래스를 선언하고 .을 통해서 확장할 수 있다.
 */

fun String.first(): Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

class MyExample {
    fun printMessage() = println("클래스 출력")
}

/**
 * 동일한 시그니처가 있을 경우 기존 클래스를 반환한다
 * 인자를 다르게 변경한다던지 해야 반영이 된다.
 */
fun MyExample.printMessage(message: String) = println(message)

fun MyExample?.printNullOrNotNull() {
    if (this == null) println("Null 인 경우에만 출력")
    else println("Null이 아닌 경우에만 출력")
}

fun main() {
    println("ABCD".first())
    println("ABCD".addFirst('Z'))

    MyExample().printMessage()
    MyExample().printMessage("확장 출력")

    var myExample: MyExample? = null
    myExample.printNullOrNotNull()

    myExample = MyExample()
    myExample.printNullOrNotNull()
}