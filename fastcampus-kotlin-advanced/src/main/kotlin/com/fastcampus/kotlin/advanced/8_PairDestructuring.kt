package com.fastcampus.kotlin.advanced

fun plus(a: Int, b: Int) = a + b

/**
 * 튜플
 * f((1, 3)) = 1 + 3 = 4
 */
data class Tuple(val a: Int, val b: Int)
fun plus(tuple: Tuple) = tuple.a + tuple.b

/**
 * Pair
 */
fun plus(pair: Pair<Int, Int>) = pair.first + pair.second

fun main() {
    // println(plus(1, 3))

    val plusByTuple = plus(Tuple(1, 3))
    println(plusByTuple)

    val plusByPair = plus(Pair(1, 3))
    println(plusByPair)

    val pair = Pair("A", 1)
    // pair.first = "B" // 직접 접근 불가

    val newPair = pair.copy(first = "B")
    println(newPair)

    val second = newPair.component2()
    println(second)

    val list = newPair.toList() // immutable list
    println(list)

    val triple = Triple("A", "B", "C")
    println(triple)

    val newTriple = triple.copy(third = "D")
    println(newTriple)

    val (a, b, c) = newTriple
    println("$a, $b, $c")

    val tripleList = newTriple.toList()
    val (a1, a2, a3) = tripleList
    println("$a1, $a2, $a3")

    tripleList.component1()
    tripleList.component2()
    tripleList.component3()
    // tripleList.component4()
    // tripleList.component5()
    // tripleList.component6()  // 5개 까지만 제공

    val map = mutableMapOf("haeny" to "개발자")
    // val map = mutableMapOf(Pair("haeny", "개발자"))
    for ((key, value) in map) {
        println("$key 의 직업은 $value")
    }

}