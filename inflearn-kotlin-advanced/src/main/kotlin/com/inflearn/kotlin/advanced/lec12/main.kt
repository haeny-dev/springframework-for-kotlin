package com.inflearn.kotlin.advanced.lec12

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000L),
        Fruit("바나나", 3000L),
    )

    // 2,000,000 개가 있다고 할 때
    // 한 원소에 대해 모든 연산을 수행하고 다음 연산으로 넘어간다.
    // 최종연산이 나오기 전까지 계산 자체를 미리 하지 않는다. (지연연산)
    val avg = fruits.asSequence()
        .filter { it.name == "사과" } // 중간연산
        .map { it.price }           // 중간연산
        .take(10_000)           // 중간연산
        .average()                  // 최종연산
}

data class Fruit(
    val name: String,
    val price: Long,
)