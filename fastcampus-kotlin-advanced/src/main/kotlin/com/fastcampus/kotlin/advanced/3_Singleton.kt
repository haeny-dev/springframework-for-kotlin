package com.fastcampus.kotlin.advanced

import java.time.LocalDateTime

/**
 * Singleton
 * - 코틀린의 싱글톤은 객체 선언으로 이뤄진다
 */
object Singleton {
    val a = 1234
    fun printA() = println(a)
}

object DatetimeUtils {
    val now: LocalDateTime
        get() = LocalDateTime.now()

    /**
     * const 로 선언
     * - Java 의 상수 선언하는 것과 같다고 볼 수 있다.
     */
    const val DEFAULT_FORMAT = "YYYY-MM-DD"

    fun same(a: LocalDateTime, b: LocalDateTime): Boolean {
        return a == b
    }
}

class MyClass {

    private constructor()

    /**
     * 동반 객체
     * - Companion 생략이 가능해서 잘 사용하지 않는다
     * - 동반객체에 이름을 붙이면 사용할 수 없다.
     */
    companion object MyCompanion {
        val a = 1234

        fun newInstance() = MyClass()
    }
}

fun main() {
    println(Singleton.a)
    Singleton.printA()

    println(DatetimeUtils.now)
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)
    println(DatetimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DatetimeUtils.same(now, now))

    println(MyClass.a)
    println(MyClass.newInstance())

//    println(MyClass.Companion.a)
//    println(MyClass.Companion.newInstance())

    println(MyClass.MyCompanion.a)
    println(MyClass.MyCompanion.newInstance())
}