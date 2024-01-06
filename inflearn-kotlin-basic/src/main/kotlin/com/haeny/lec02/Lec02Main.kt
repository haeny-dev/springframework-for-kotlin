package com.haeny.lec02

import java.lang.IllegalArgumentException

fun main() {

    /* Safe Call */
    val str: String? = null
    println(str?.length ?: 0)
    println(startsWith("ABC"))

//    val person = Person("공부하는 개발자")
//    startsWithA(person.name)

    /**
     * Kotlin 에서 Java 의 아래와 같은 애노테이션을 이해하여 처리합니다.
     * - javax.annotation 패키지
     * - android.support.annotation 패키지
     * - org.jetbrains.annotation 패키지
     *
     * 하지만, 그런 애노테이션이 없다면 nullable 인지 Non-null인지 알 수 없다.
     * 이러한 타입을 플랫폼 타입이라고 한다.
     * Runtime 시 Exception 을 발생시킬 수 있다.
     */

    val person = Person(null)
    startsWithA(person.name)
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}

fun startsWithA1(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다.")

//    if (str == null) {
//        throw IllegalArgumentException("null이 들어왔습니다.")
//    }
//
//    return str.startsWith("A")
}

fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")

//    if (str == null) {
//        return null
//    }
//
//    return str.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false

//    if (str == null) {
//        return false
//    }
//
//    return str.startsWith("A")
}

fun startsWith(str: String?): Boolean {
    return str!!.startsWith("A")
}