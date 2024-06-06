package com.inflearn.kotlin.advanced.lec10

import kotlin.properties.Delegates.notNull
import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

fun main() {
//    val p = Person()
//    p.age = 30

    val person = Person(mapOf("name" to "ABC", "age" to 123))
    println(person.name)
    println(person.age)
}

class Person(map: Map<String, Any>) {
//    var age: Int by notNull()

//    var age: Int by observable(20) { _, oldValue, newValue ->
//        println("이전 값 : $oldValue / 새로운 값 : $newValue")
//    }

//    var age: Int by vetoable(20) { _, _, newValue -> newValue >= 1 }

//    @Deprecated("age를 사용하세요", ReplaceWith("age"))
//    var num: Int = 0

//    var age: Int by this::num

    val name: String by map
    val age: Int by map
}