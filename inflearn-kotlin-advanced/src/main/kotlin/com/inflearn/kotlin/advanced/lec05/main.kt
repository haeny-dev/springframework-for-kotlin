package com.inflearn.kotlin.advanced.lec05

import com.inflearn.kotlin.advanced.lec01.Animal

// 제네릭 제약
// class Cage5<T : Animal> { // 1개의 제약조건만 줄 경우
// 여러 제약 조건을 줄 경우
// Non-null 타입 한정에 사용할 수도 있다 T : Any
class Cage5<T>(
    private val animals: MutableList<T> = mutableListOf()
) where T : Animal, T : Comparable<T> {

    fun printAfterSorting() {
        this.animals.sorted()
            .map { it.name }
            .let { println(it) }
    }

    fun getFirst(): T = animals.first()

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun moveFrom(otherCage: Cage5<T>) {
        this.animals.addAll(otherCage.animals)
    }

    fun moveTo(otherCage: Cage5<T>) {
        otherCage.animals.addAll(this.animals)
    }
}

abstract class Bird(
    name: String,
    private val size: Int,
) : Animal(name), Comparable<Bird> {
    override fun compareTo(other: Bird): Int = this.size.compareTo(other.size)
}

class Sparrow : Bird("참새", 100)
class Eagle : Bird("독수리", 500)

fun main() {
    val cage = Cage5(mutableListOf(Eagle(), Sparrow()))
    cage.printAfterSorting()
}

fun <T> List<T>.hasIntersection(other: List<T>): Boolean {
    return (this.toSet() intersect other.toSet()).isNotEmpty()
}
