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

    // out: variance(변성) annotation
    // 데이터를 꺼낼 수만 있다.
    // 생산자 역할만 한다.
    // 타입안정성이 깨지기 때문에..
    fun moveFrom(otherCage: Cage2<out T>) {
        otherCage.getFirst()
//        otherCage.put(Carp("잉어")) // Error
        this.animals.addAll(otherCage.animals)
    }

    // 반공변(contra-variance) 하게 만들자
    // 함수 파마리터 입장에서의
    // 소비자, 반공변
    fun moveTo(otherCage: Cage2<in T>) {
        otherCage.animals.addAll(this.animals)
    }
}

fun main() {
    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))

    val fishCage = Cage2<Fish>()
    fishCage.moveFrom(goldFishCage)

    val fish: Fish = fishCage.getFirst()
}