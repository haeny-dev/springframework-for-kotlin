package com.fastcampus.kotlin.basic

// 변수를 탑 레벨에 선언 가능
var x = 5

fun main() {
    val a: Int = 1

    /**
     * 변수 생략 가능
     * - 코틀린 컴파일러가 타입을 자동으로 추론함
     */
    val b = 1

    /**
     * 지연할당
     * - 타입을 명시하지 않으면 컴파일 에러 발생
     */
    val c: Int
    c = 3

    /**
     * 변수 선언 키워드
     * - val(value): 값을 한 번 초기화하면 재할당 불가
     * - var(variable): 가변 변수를 나타내는 변수
     */
    val e: String = "Hello"
//    e = "World"   // 컴파일 에러 발생: 재할당 불가

    var f = 123
//    f = "hi"  // 컴파일 에러 발생: 한 번 타입이 지정되면 타입 재할당 불가

    x += 1
    println(x)
}