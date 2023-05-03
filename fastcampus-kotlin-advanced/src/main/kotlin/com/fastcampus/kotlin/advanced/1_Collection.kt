package com.fastcampus.kotlin.advanced

import java.util.LinkedList
import java.util.stream.Collectors

fun main() {

    /**
     * Immutable List
     * - 추가 혹은 삭제하는 메서드가 존재하지 않음
     * - 한 번 할당되면 추가하거나 삭제할 수 없음
     */
    val currencyList = listOf("달러", "유로", "원")
//    currencyList.add()

    /**
     * Mutable List
     */
    var mutableCurrencyList = mutableListOf<String>()
    mutableCurrencyList.add("달러")
    mutableCurrencyList.add("유로")
    mutableCurrencyList.add("원")

    mutableCurrencyList = mutableListOf<String>().apply {
        add("달러")
        add("유로")
        add("d원")
    }

    /**
     * Immutable Set
     */
    val numberSet = setOf(1, 2, 3, 4)

    /**
     * Mutable Set
     */
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    /**
     * Immutable Map
     */
    val numberMap = mapOf(
        "one" to 1,
        "two" to 2
    )

    /**
     * Mutable Map
     */
    val mutableMap = mutableMapOf<String, Int>()
    mutableMap["one"] = 1
    mutableMap.put("two", 2)    // 코틀린에서는 리터럴 문법을 사용하는 것을 추천하고 있음
    mutableMap["three"] = 3

    /**
     * Collection Builder
     * - buildList > 내부에서는 MutableList 를 사용하고 반환할 때는 Immutable List 를 반환한다.
     */
    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }

    /**
     * Java 의 list도 생성이 가능하다.
     */
    // linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    // arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    // 자바의 foreach 와 마찬가지로 내부적으로 iterator 를 사용
    for (currency in currencyList) {
        println(currency)
    }

    currencyList.forEach {
        println(it)
    }

    /**
     * map
     */
    val lowerList = listOf("a", "b", "c")
    val upperList = mutableListOf<String>()

    for (lowerCase in lowerList) {
        upperList.add(lowerCase.uppercase())
    }

    println(upperList)
    println(lowerList.map { it.uppercase() })

    /**
     * filter
     */
    val filteredList = mutableListOf<String>()
    for (upperCase in upperList) {
        if (upperCase == "A" || upperCase == "C") {
            filteredList.add(upperCase)
        }
    }

    println(filteredList)
    println(upperList.filter { it == "A" || it == "C" })

    println(
        upperList.stream()
            .filter { it == "A" || it == "C" }
            .collect(Collectors.toList())
    )

    /**
     * asSequence()
     * - 대량의 데이터에 대해서 인라인 함수가 많아지는 경우 사용하면 메모리를 절약할 수 있다.
     */
    println(
        upperList.asSequence()
            .filter { it == "A" || it == "C" }
            .filter { it == "C" }
            .filter { it == "C" }
            .filter { it == "C" }
            .filter { it == "C" }
            .toList()   // asSequence 를 사용할 경우 최종 연산자를 사용
    )
}