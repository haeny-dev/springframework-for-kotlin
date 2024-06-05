package com.inflearn.kotlin.advanced.lec04

import com.inflearn.kotlin.advanced.lec01.Animal
import com.inflearn.kotlin.advanced.lec01.Fish

fun main() {
    val fishCage = Cage3<Fish>()
    val animalCage: Cage3<Animal> = fishCage
}

// 생산만 하는 클래스
class Cage3<out T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T = this.animals.first()

    fun getAll(): List<T> = this.animals
}

// 소비만 하는 클래스
class Cage4<in T> {
    private val animals: MutableList<T> = mutableListOf()

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun putAll(animals: List<T>) {
        this.animals.addAll(animals)
    }
}