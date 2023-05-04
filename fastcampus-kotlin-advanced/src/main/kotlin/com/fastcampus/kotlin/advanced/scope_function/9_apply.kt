package com.fastcampus.kotlin.advanced.scope_function

/**
 * apply
 * - 수신 객체의 프로퍼티를 구성하고
 * - 수신 객체를 그대로 반환하고 싶을 떄
 */

fun main() {

    val client = DatabaseClient().apply {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }

    val connected = client.connect()
    println(connected)
}