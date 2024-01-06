package com.haeny.lec09.kotlin

import java.lang.IllegalArgumentException

/**
 * constructor 생략 가능
 * 클래스의 필드 선언과 생성자의 프로퍼티 선언을 합칠 수 있다.
 */
class Person(   // 주생성자 -> 반드시 존재해야 한다.
    name: String,
    var age: Int){

    /**
     * Custom getter
     * get() = name.uppercase() 라고 사용할 경우
     * name. 에서 get() 을 호출하여 무한루프가 발생한다.
     * 무한루프를 막기 위한 자기 자신을 가리키는 예약어 field 를 사용
     * 자기 자신을 가리키는 보이지 않는 필드라고 해서 backing field 라 한다.
     */
    var name = name
        get() = field.uppercase()
        set(value){
            field = value.uppercase()
        }

    val uppercaseName: String
        get() = this.name.uppercase()

    /**
     * 코틀린에서는 필드만 만들면 getter, setter 를 생성해준다.
     * .필드를 통해서 가져올 수 있다.
     *
     * 코를린에서 자바 클래스를 가져다가 사용할 때도 .필드를 사용할 수 있다.
     */

    /* 클래스가 초기화 되는 시점에 한 번 호출되는 블록 */
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("초기화 블록")
    }

    /* 부생성자 -> 최종적으로 주생성자를 호출해야 한다.
     * 코틀린에서는 부생성자보다는 default parameter 를 권장
     */
    constructor(name: String): this(name, 1){
        println("첫 번째 부생성자")
    }

    constructor(): this("홍길동"){
        println("두 번째 부생성자")
    }
    /* 함수처럼 만드는 방식 */
//    fun isAdult(): Boolean{
//        return this.age >= 20
//    }

    /* 프로퍼티처럼 만드는 방식 */
    val isAdult: Boolean
        get() = this.age >= 20
}

fun main() {
    val person = Person("정주현", 100)
    println(person.name)
    person.age = 10     // setter를 호출
    println(person.age)

    val newPerson = Person("신생아")
    println("${newPerson.name}은 ${newPerson.age}살 입니다.")

    val xPerson = Person()
    println("${xPerson.name}은 ${xPerson.age}살 입니다.")
}