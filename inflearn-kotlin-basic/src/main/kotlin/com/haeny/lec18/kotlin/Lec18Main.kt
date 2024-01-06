package com.haeny.lec18.kotlin

import com.haeny.lec18.java.Fruit

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

    filterFruits(fruits) { it.name == "사과" }

    // filter
    val apples = fruits.filter { fruit -> fruit.name == "사과" }
    // filterIndexed
    fruits.filterIndexed { idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }

    // map
    val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.price }
    // mapIndexed
    fruits.filter { fruit -> fruit.name == "사과" }
        .mapIndexed { idx, fruit ->
            println(idx)
            fruit.price
        }

    // mapNotNull
    fruits.filter { fruit -> fruit.name == "사과" }
        .mapNotNull { fruit -> fruit.nullOrValue() }

    // all
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }

    // none
    val isNotApple = fruits.none { fruit -> fruit.name == "사과" }

    // any
    fruits.any { fruit -> fruit.price >= 10_000 }

    // count
    fruits.count()

    // sortedBy (오름차순)
    fruits.sortedBy { fruit -> fruit.price }
    // 내림차순
    fruits.sortedByDescending { fruit -> fruit.price }

    // distinctBy
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.name }

    // first, firstOrNull
    fruits.first()
    fruits.firstOrNull()

    // last, lastOrNull
    fruits.last()
    fruits.lastOrNull()

    // key: 과일이름, value: List<과일> 인 Map이 필요
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }

    // key: id, value: 과일
    val map2: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }

    // key: 과일이름, value: List<가격> 인 Map이 필요
    val map3: Map<String, List<Int>> = fruits.groupBy(
        { fruit -> fruit.name },
        { fruit -> fruit.price }
    )

    // key: id, value: 가격 인 Map 필요
    val map4: Map<Long, Int> = fruits.associateBy(
        { fruit -> fruit.id },
        { fruit -> fruit.price }
    )

    // map 에 대해서도 앞선 기능들 대부분 사용이 가능
    val map5: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
        .filter { (key, value) -> key == "사과" }

    val fruitsInList: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1L, "사과", 1_000, 1_500),
            Fruit(2L, "사과", 1_200, 1_500),
            Fruit(3L, "사과", 1_200, 1_500),
            Fruit(4L, "사과", 1_500, 1_500),
        ),
        listOf(
            Fruit(5L, "바나나", 3_000, 3_200),
            Fruit(6L, "바나나", 3_200, 3_200),
            Fruit(7L, "바나나", 2_500, 3_200),
        ),
        listOf(
            Fruit(8L, "수박", 10_000, 10_000),
        ),
    )

    // 출고가와 현재가가 동일한 과일을 골라주세요
    val samePriceFruits = fruitsInList.flatMap { list ->
        list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice }
    }

    // List<List<>> -> List<>
    fruitsInList.flatten()
}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(filter)
}
