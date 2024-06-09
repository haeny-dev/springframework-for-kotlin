package com.inflearn.kotlin.advanced.lec16

/**
 * SAM Interface
 * - 추상 메소드를 하나만 갖고 있는 인터페이스
 *
 * 코틀린에서의 SAM 인스턴스화
 * - 람다식 만으로는 인스턴스화 할 수 없고,
 * - SAM 인터페이스명과 람다식으로 인스턴스화 할 수 있다.
 * => SAM 생성자라고 부른다.
 * => but, 변수에 넣을게 아닌 매개변수로 쓰일 때는 람다식으로만 사용 가능하다.
 */

fun main() {
    consumeFilter(KStringFilter { str: String -> str.startsWith("A") })

    // 호출 가능 참조(Callable Reference)
    val add3 = ::add
}

fun consumeFilter(filter: KStringFilter) { }

/**
 * 코틀린에서 SAM Interface 를 만들려면
 */
fun interface KStringFilter {
    fun predicate(str: String): Boolean
}

fun add(a: Int, b: Int) = a + b