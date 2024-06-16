package com.inflearn.kotlin.advanced.lec20

/**
 * @Retention
 * 해당 어노테이션이 저장되고 유지되는 방식을 제어
 * - SOURCE: 어노테이션이 컴파일 때만 존재한다.
 * - BINARY: 어노테이션이 런타임 때도 있지만, 리플렉션을 쓸 수 없다.
 * - RUNTIME: 어노테이션이 런타임 때 존재하고, 리플렉션을 쓸 수 있다.
 *
 * @Target
 * 해당 어노테이션을 어디에 붙일지 선택
 * 여러 개를 붙일 수 있음
 *
 * KClass
 * 코드로 작성한 클래스를 표현한 클래스
 *
 * Repeatable 어노테이션
 * 한 언어 요소에 여러번 붙일 수 있는 어노테이션
 */

fun main() {
}

/**
 * 어노테이션의 위치가 애매한 경우
 * use-site target 을 명확하게 지정해주어야 한다.
 * - property: 프로퍼티 자체
 * - field: 필드
 * - get: 프로퍼티 게터
 * - set: 프로퍼티 세터
 * - param: 생성자의 파라미터
 * - setparam: 프로퍼티 setter 의 파라미터
 * - delegate: 위임 객체를 저장하는 필드
 * - receiver: 확장 함수나 확장 프로퍼티의 수신 객체
 * - file: 전체 파일
 *
 * 여러 언어 요소에 어노테이션이 붙을 수 있다면,
 * param > property > field 순서
 */
// class Hello(@get:Shape val name: String)

@Shape(["aa", "bb"])
@Shape(["cc", "dd"])
class Annotation

@Repeatable
@Retention(AnnotationRetention.RUNTIME)
annotation class Shape(
    val texts: Array<String>,
//    val number: Int,
//    val clazz: KClass<*>,
)
