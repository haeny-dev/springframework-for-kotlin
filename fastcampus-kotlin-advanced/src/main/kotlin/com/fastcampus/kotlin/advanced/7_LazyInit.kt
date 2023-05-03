package com.fastcampus.kotlin.advanced

/**
 * by lazy
 */
class HelloBot {

    val greeting: String by lazy/*(LazyThreadSafetyMode.NONE)*/ {
        println("초기화 로직 수행")
        getHello()
    }

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {
    val helloBot = HelloBot()

   // helloBot.greeting = getHello()
   helloBot.sayHello() // 이 때만 초기화 로직이 실행된다.
   helloBot.sayHello()
   helloBot.sayHello()

    // 멑티스레드에 안전하게 설계되어 있다.
    for (i in 1..5) {
        Thread {
            helloBot.sayHello()
        }.start()
    }
}