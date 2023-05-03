package com.fastcampus.kotlin.advanced

/**
 * lateinit
 * - 가변 프로퍼티에 대한 지연초기화가 필요할 때
 * - DI 와 같이 외부에서 초기화 해주는 경우를 대비해서 만든 기능
 */
class LateInit {
    lateinit var text: String

    val textInitialized: Boolean
        get() = this::text.isInitialized

    fun printText() {
        if(this::text.isInitialized){
            println("초기화됨")
        } else {
            text = "안녕하세요"
        }
        println(text)
    }
}

fun main() {
    val test = LateInit()

    if (!test.textInitialized) {
        test.text = "하이"
        test.printText()
    }

    test.printText()
    test.printText()

//    test.text.isInitialized   // 사용불가
}