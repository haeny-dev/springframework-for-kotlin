package com.fastcampus.kotlin.advanced.scope_function

/**
 * also
 * - 부수작업을 수행하고,
 * - 전달받은 수신객체를 그대로 반환하고 싶을 떄
 */

class User(
    val name: String,
    val password: String,
) {
    fun validate() {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            println("검증 성공!")
        } else {
            println("검증 실패!")
        }
    }

    fun printName() = println(name)
}


fun main() {
    // val user = User(name = "tony", password = "1234")
    // user.validate()

    val user = User(name = "tony", password = "1234").also {
        it.validate()
        it.printName()
    }
}