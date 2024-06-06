package com.inflearn.kotlin.advanced.lec07

import com.inflearn.kotlin.advanced.lec01.Animal
import com.inflearn.kotlin.advanced.lec01.GoldFish

fun main() {
    val cage = Cage<GoldFish>()
//    cage.addAnimal(GoldFish("금붕어"))
//    cage.addAnimal(Carp("잉어"))
}

class Cage<T : Animal> {
    // 타입 파라미터 섀도잉
    // 가끔적 피할 것
    // 사용해야 한다면 다른 문자로 사용
    fun <T : Animal> addAnimal(animal: T) {

    }
}

// 제네릭 클래스의 상속
open class CageV1<T: Animal> {
    open fun addAnimal(animal: T) {

    }
}

// 같은 제약조건을 가지고 있어야 한다.
class CageV2<T : Animal> : CageV1<T>() {
    override fun addAnimal(animal: T) {
        super.addAnimal(animal)
    }
}

class GoldFishCageV2 : CageV1<GoldFish>() {
    override fun addAnimal(animal: GoldFish) {
        super.addAnimal(animal)
    }
}

typealias CustomMap = Map<String, String>

fun handleCustomMap(map: CustomMap) {

}