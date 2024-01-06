package com.haeny.lec01

fun main() {
    /**
     * 1. 변수 선언 키워드 - var과 val의 차이점
     *
     * var: Variable 의 약자
     * - 초기값을 지정해주지 않는 경우에 타입을 지정해주어야 함.
     */
//    var number1: Long = 10L
//    number1 = 5L

    /**
     * val: Value의 약자
     * - 초기값을 지정해주지 않는 경우에 타입을 지정해주어야 함.
     * - 초기값이 지정되지 않은 경우에 최초 한번 값을 넣어줄 수 있음.
     * - val로 컬렉션을 생성하더라도 element는 추가할 수 있다.
     */
//    val number2 = 10L
//    number2 = 5L  // 불가

    val number: Long
    number = 10L
    println(number)

    /**
     * 2. Kotlin 에서의 Primitive Type
     *
     * - 숫자, 문자, 불리언과 같은 몇몇 타입은 내부적으로 특별한 표현을 갖는다.
     * - 이 타입들은 실행시에 Primitive Value 로 표현되지만, 코드에서는 평범한 클래스 처럼 보인다.
     * - 프로그래머가  boxing/unboxing 을 고려하지 않아도 되도록 kotlin 이 알아서 처리해준다.
     */
    var number1: Long = 10L // (1)
    var number2: Long = 10L // (2)

    /**
     * 3. Kotlin 에서의 nullable 변수
     *
     * - kotlin 은 기본적으로 모든 변수를 null이 들어갈 수 없도록 설계
     * - null 이 들어갈 수 있음을 의미해주기 위해서 '타입?' 를 사용해야 한다.
     */
    var number3: Long? = 1_000L // (3)
    number3 = null

    /**
     * 4. Kotlin 에서의 객체 인스턴스화
     * - kotlin 에서는 new 를 사용하지 않음
     */
    var person = Person("정주현")
}