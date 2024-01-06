package com.haeny.lec12.kotlin

fun main() {
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)
}

class Person private constructor(
    var name: String,
    var age: Int
) {
    /**
     * companion object: 클래스와 동행하는 유일한 오브젝트
     */
    companion object Factory : Log{
        /**
         * const 를 붙여주면 컴파일 시에 변수가 할당된다.
         * -> 진짜 상수를 할당하기 위한 키워드
         * -> 기본타입과 String에만 가능
         */
        private const val MIN_AGE = 1

        @JvmStatic
        fun newBaby(name: String): Person{
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스의 동행 객체 입니다.")
        }
    }
}

object Singleton {
    var a: Int = 0
}