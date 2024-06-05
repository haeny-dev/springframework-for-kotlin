package com.inflearn.kotlin.advanced.lec03

import com.inflearn.kotlin.advanced.lec01.Fish
import com.inflearn.kotlin.advanced.lec01.GoldFish
import com.inflearn.kotlin.advanced.lec02.Cage2

fun main() {
    val fishCage = Cage2<Fish>()

    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))
    goldFishCage.moveTo(fishCage)
}