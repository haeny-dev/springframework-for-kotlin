package com.inflearn.kotlin.advanced.lec08

/**
 * lateinit
 * - 초기화를 지연시킨 변수, 초기화 로직이 여러 곳에 위치할 수 있다.
 * - 초기화 없이 호출하면 예외가 발생한다.
 *
 * lazy
 * - 초기화를 get 호출 전으로 지연시킨 변수
 * - 초기화 로직은 변수 선언과 동시에 한 곳에만 위치할 수 있다.
 */
fun main() {
}

class Person {
    // lateinit 변수는 컴파일 단계에서 nullable 변수로 바뀌고, 변수에 접근하려 할 때 null 이면 예외가 발생한다.
    // nullable 로 만들기 때문에 primitive type 에는 불가능하다.
    lateinit var name: String

    val isKim: Boolean
        get() = this.name.startsWith("김")

    val maskingName: String
        get() = name[0] + (1 until name.length).joinToString("") { "*" }
}

class Person2 {
    // name 과 대응하는 외부로 드러나지 않는 프로퍼티: Backing Property
    private var _name: String? = null
    val name: String
        get() {
            if (_name == null) {
                // 초기화 로직
                Thread.sleep(2_000L)
                this._name = "김수한무"
            }
            return this._name!!
        }

    val age: Int by lazy {
        Thread.sleep(2_000L)
        20
    }
}
