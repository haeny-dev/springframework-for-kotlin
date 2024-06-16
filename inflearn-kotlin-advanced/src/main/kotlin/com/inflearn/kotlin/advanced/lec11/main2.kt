package com.inflearn.kotlin.advanced.lec11

fun main() {
}

interface Fruit {
    val name: String
    val color: String
    fun bite()
}

open class Apple : Fruit {
    override val name: String
        get() = "사과"
    override val color: String
        get() = "빨간색"

    override fun bite() {
        println("사과 아삭")
    }
}

class GreenApple : Fruit {
    override val name: String
        get() = "사과"
    override val color: String
        get() = "초록색"

    override fun bite() {
        println("사과 아삭")
    }
}

class GreenApple2 : Apple() {
    override val color: String
        get() = "초록색"
}

// 클래스의 위임
class GreenApple3(
    private val apple: Apple,
) : Fruit by apple {
    override val color: String
        get() = "초록색"
}
