package com.haeny.lec17.kotlin

import com.haeny.lec17.java.Fruit

fun main() {

    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000),
    )

    // 람다를 만드는 방법1
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 람다를 만드는 방법2
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과"}

//    isApple(fruits[0])
//    isApple.invoke(fruits[0])

    filterFruits(fruits, isApple)
//    filterFruits(fruits, isApple2)
//    filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과"})
//    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
//    filterFruits(fruits) { fruit -> fruit.name == "사과" }
    filterFruits(fruits) { it.name == "사과" }

    var targetFruitName = "바나나"
    targetFruitName = "수박"

    // Closure
    filterFruits(fruits) { it.name == targetFruitName}
}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits){
        if(filter(fruit)){
            results.add(fruit)
        }
    }
    return results
}
