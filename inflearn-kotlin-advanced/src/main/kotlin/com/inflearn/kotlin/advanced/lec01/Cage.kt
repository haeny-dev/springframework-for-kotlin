package com.inflearn.kotlin.advanced.lec01

class Cage {
    private val animals: MutableList<Animal> = mutableListOf()

    fun getFirst(): Animal = animals.first()

    fun put(animal: Animal) {
        this.animals.add(animal)
    }

    fun moveFrom(cage: Cage) {
        this.animals.addAll(cage.animals)
    }
}

class Cage2<T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T = animals.first()

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun moveFrom(cage: Cage2<T>) {
        this.animals.addAll(cage.animals)
    }
}

fun main() {
    val cage = Cage()
    cage.put(Carp("잉어"))
//    val carp: Carp = cage.getFirst()    // Error: Type Mismatch
//    val carp: Carp = cage.getFirst() as Carp

    cage.put(GoldFish("사실은 금붕어"))
    val carp: Carp = cage.getFirst() as Carp    // Runtime Error

    val cage2 = Cage2<Carp>()
    cage2.put(Carp("잉어"))
    val carp2 = cage2.getFirst()

    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))

    val fishCage = Cage2<Fish>()
//    fishCage.moveFrom(goldFishCage)
}