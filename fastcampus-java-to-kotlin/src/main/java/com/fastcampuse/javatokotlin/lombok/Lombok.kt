package com.fastcampuse.javatokotlin.lombok

fun main() {
    // val hero = Hero()
    //
    // hero.address = "NewYork"
    // println(hero.address)
    //
    // hero.name = "아이언맨"
    // println(hero.name)

    val heroKt = HeroKt(
        name = "아이언맨",
        age = 53,
        address = "NewYork"
    )
    println(heroKt)
}

/**
 * 코틀린과 자바 통합 프로젝트에서 컴파일 되는 과정
 *
 * 코틀린 코드(.kt) ==> 코틀린 컴파일러 (kotlinc)
 *                                          ==> 바이트 코드 (.class)
 * 자바 코드(.java) ==> 자바 컴파일러 (javac)             |
 *                                                  |
 *                                              애노테이션 프로세싱 ==> 바이트 코드(.class) ==> JVM
 */