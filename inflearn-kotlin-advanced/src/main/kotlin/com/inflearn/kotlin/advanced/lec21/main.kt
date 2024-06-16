package com.inflearn.kotlin.advanced.lec21

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KType
import kotlin.reflect.cast
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.createType
import kotlin.reflect.full.hasAnnotation

fun main() {
    val ref = Reflection()
    val kClass2: KClass<out Reflection> = ref::class

    val kClass3: KClass<out Any> = Class.forName("com.inflearn.kotlin.advanced.lec21.Reflection").kotlin
    kClass2.java // Class<Reflection>
    kClass2.java.kotlin // KClass<Reflection>

    // KType, 타입을 표현
    val kType: KType = GoldFish::class.createType()

    val goldFish = GoldFish("금붕이")
    goldFish::class.members.first { it.name == "print" }.call(goldFish)

    executeAll(Reflection())
}

@Target(AnnotationTarget.CLASS)
annotation class Executable

@Executable
class Reflection {
    fun a() {
        println("A 입니다.")
    }

    fun b(n: Int) {
        println("B 입니다.")
    }
}

fun executeAll(obj: Any) {
    val kClass = obj::class
    if (!kClass.hasAnnotation<Executable>()) {
        return
    }

    val callableFunctions = kClass.members.filterIsInstance<KFunction<*>>()
        .filter { it.returnType == Unit::class.createType() }
        .filter { it.parameters.size == 1 && it.parameters[0].type == kClass.createType() }

    callableFunctions.forEach { function ->
        function.call(obj)
    }
}

class GoldFish(val name: String) {
    fun print() {
        println("금붕어 이름은 $name 입니다.")
    }
}

fun caseToGoldFish(obj: Any): GoldFish {
    return GoldFish::class.cast(obj)
}