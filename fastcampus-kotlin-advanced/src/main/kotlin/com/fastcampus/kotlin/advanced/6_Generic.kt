package com.fastcampus.kotlin.advanced

/**
 * Generic
 * - 타입 파라미터를 사용하여 생성해준다.
 *
 * PECS(Producer-Extends, Consumer-Super)
 * - 공변성은 자바 제네릭의 extends 코틀린에선 out
 * - 반공변성은 자바 제네릭의 super 코틀린에선 in
 */
class MyGeneric<out T>(val t: T)

class Bag<T> {

    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>,
    ) {
        to.addAll(from)
    }
}

fun main() {

    /**
     * 제네릭을 사용한 클래스의 인스턴스를 만드려면 타입 아규먼트를 제공
     * - 타입 추론이 가능한 경우 생략 가능
     */
    // val generics = MyGeneric<String>("테스트")
    val generics = MyGeneric("테스트")

    // 변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()

    // 타입아규먼트를 생성자에서 추가
    val list2 = mutableListOf<String>()

    // 정확한 타입을 몰라도 제네릭을 활용할 수 있도록 * 를 제공한다
    val list3: List<*> = listOf("테스트")
    val list4: List<*> = listOf(1, 2, 3, 4)

    val charGenerics: MyGeneric<CharSequence> = generics

    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4"))

    // val bag2 = Bag<CharSequence>()
    // bag2.saveAll(mutableListOf<String>("3", "4"))    // 컴파일 에러
}