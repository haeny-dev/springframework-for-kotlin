package com.inflearn.kotlin.advanced.lec02

import com.inflearn.kotlin.advanced.lec01.Carp
import com.inflearn.kotlin.advanced.lec01.Fish
import com.inflearn.kotlin.advanced.lec01.GoldFish

class Cage2<T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T = animals.first()

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun moveFrom(otherCage: Cage2<T>) {
        this.animals.addAll(otherCage.animals)
    }
}

fun main() {
    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))

    val fishCage = Cage2<Fish>()
//    fishCage.moveFrom(goldFishCage)   // Error
}