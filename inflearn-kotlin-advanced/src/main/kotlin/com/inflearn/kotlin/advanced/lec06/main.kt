package com.inflearn.kotlin.advanced.lec06

fun main() {
//    val numbers: List = listOf(1, 2, 3)   // Error

    val num = 3
    num.toSuperString() // "Int: 3"

    val str = "ABC"
    str.toSuperString() // "String: ABC"

    val numbers = listOf(1, 2f, 3.0)
    numbers.filterIsInstance<Float>()
}
// inline 함수: 코드의 본문을 호출 지점으로 이동시켜 컴파일되는 함수
// reified 키워드가 붙은 타임 T를 이용해
// T 의 인스턴스를 만들거나 T의 Companion object 를 가져올 순 없다
inline fun <reified T> List<*>.hasAnyInstanceOf(): Boolean {
    return this.any { it is T }
}


fun <T> T.toSuperString() {
    // 제네릭은 Runtime 때 클래스 정보가 사라진다.
//    println("${T::class.java.name}: $this")
}

fun checkList(data: Any) {

    // star projection
    // 타입 파라미터에 뭐가 있을지 모른다
    // 타입 정보는 모르지만 리스트의 기능은 사용할 수 있다.
    if (data is List<*>) {
        val element: Any? = data[0]
    }
}