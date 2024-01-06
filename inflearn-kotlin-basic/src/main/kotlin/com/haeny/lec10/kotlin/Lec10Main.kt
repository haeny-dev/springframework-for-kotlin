package com.haeny.lec10.kotlin

fun main() {
    Derived(300)
}

open class Base(
    open val number: Int = 100
){
    init{
        println("Base Class")
        println(number)
    }
}

class Derived(
    override val number: Int
) : Base(number){

    init{
        println("Derived Class")
    }
}