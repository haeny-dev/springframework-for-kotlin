package com.inflearn.kotlin.advanced.lec26

/**
 * kdoc
 * 코틀린 코드의 문서화를 위해 작성되는 언어
 */

// kdoc <Block Tag>
/**
 * 박스를 나타내는 클래스.
 *
 * **강조**
 * - A
 * - B
 * - C
 *
 * @param T 박스의 아이템 타입
 * @property name 박스의 이름
 * @sample com.inflearn.kotlin.advanced.lec26.helloWorld
 */
class Box<T>(val name: String) {
    fun add(item: T): Boolean {
        TODO()
    }
}

fun helloWorld() {
    println("Hello World")
}
