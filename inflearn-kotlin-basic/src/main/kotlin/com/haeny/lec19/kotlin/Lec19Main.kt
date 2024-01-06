package com.haeny.lec19.kotlin

import com.haeny.lec19.java.Fruit

/* as import */
import com.haeny.lec19.kotlin.a.printHelloWorld as printHelloWorldA
import com.haeny.lec19.kotlin.b.printHelloWorld as printHelloWorldB

fun main() {
    printHelloWorldA()
    printHelloWorldB()

    /* 구조분해 */
    val person = Person("정주현", 100)
//    val name = person.component1()
//    val age = person.component2()

    val (name, age) = person

    println("이름: ${name}, 나이: ${age}")

    /* continue, break */
    val numbers = listOf(1, 2, 3)
    numbers.map { number -> number + 1 }
        .forEach { number -> println(number) }

    for(number in numbers){
        if (number == 2) {
            break
        }
    }

    numbers.forEach { number ->
        if (number == 2) {
//            break, continue 동작안함
        }
    }

    // break 굳이 쓴다면
    run {
        numbers.forEach { number ->
            if (number == 2) {
                return@run
            }
        }
    }

    // continue 굳이 쓴다면
    numbers.forEach { number ->
        if (number == 2) {
            return@forEach
        }
    }

    /* Label */
    abc@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@abc
            }
            println("${i} ${j}")
        }
    }
}

/* Type Alias */
typealias FruitFilter = (Fruit) -> Boolean

fun filterFruits(fruits: List<Fruit>, filter: FruitFilter) {}

data class UltraSuperGuardianTribe(
    val name: String
)

typealias USGTMap = Map<String, UltraSuperGuardianTribe>

/* data */class Person(
    val name: String,
    val age: Int
) {
    /* data 클래스가 아닌 클래스에도 구현할 수 있음 */
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}

fun getNumberOrNull(number: Int): Int? {
//    return if (number <= 0) {
//        null
//    } else {
//        number
//    }

//    return number.takeIf { it > 0 }
    return number.takeUnless { it <= 0 }
}

