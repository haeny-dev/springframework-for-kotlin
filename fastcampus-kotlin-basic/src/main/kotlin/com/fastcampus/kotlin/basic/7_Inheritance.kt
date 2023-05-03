package com.fastcampus.kotlin.basic

/**
 * 코틀린은 기본적으로 final 클래스이며,
 * 상속을 허용할 때는 open 키워드를 통해서 열어줄 수 있다.
 */
open class Dog {
    open var age: Int = 0

    open fun bark() {
        println("멍멍")
    }
}

// class Bulldog : Dog() {
//    override var age : Int = 0
//
//    override fun bark() {
//        println("컹컹")
//    }
// }

/**
 * 기본생성자를 통해서도 재정의를 할 수 있다.
 */
open class Bulldog(
    override var age: Int = 0
) : Dog() {
    final override fun bark() {
        println("컹컹")
    }
}

/**
 * 상속을 통해 오버라이드 된 메서드는 자동으로 open 상태가 되기 때문에
 * 다시 재정의를 막기 위해서는 final 키워드를 사용해서 막을 수 있다.
 */
class ChildBulldog(
    override var age: Int = 0
) : Bulldog() {

    // 컴파일 에러 발생
    // override fun bark() {
    //     super.bark()     // 하위 클래스에서 상위 클래스에 접근할 때 super 키워드 사용
    // }
}

/**
 * 추상클래스
 */
abstract class Developer{
    abstract var age: Int
    abstract fun code(language: String)
}

class BackendDeveloper(
    override var age: Int
) : Developer() {
    override fun code(language: String) {
        println("I code with $language")
    }
}

fun main() {
    val dog = Bulldog(age = 2)
    println(dog.age)
    dog.bark()

    val backendDeveloper = BackendDeveloper(age = 20)
    println(backendDeveloper.age)
    backendDeveloper.code("Kotlin")
}