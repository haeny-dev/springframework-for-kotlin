package com.inflearn.kotlin.advanced.lec23

import com.inflearn.kotlin.advanced.lec01.Carp
import com.inflearn.kotlin.advanced.lec01.GoldFish
import kotlin.reflect.KType

fun main() {
//    val superTypeSafeCage = SuperTypeSafeCage()
//    superTypeSafeCage.putOne(Carp::class, Carp("잉어"))
//    typeSafeCage.getOne(Carp::class)
//    val one = superTypeSafeCage.getOne<Carp>()
//    GoldFish("금붕어")

    val superTypeToken1 = object : SuperTypeToken<List<GoldFish>>() {}
    val superTypeToken2 = object : SuperTypeToken<List<GoldFish>>() {}
    val superTypeToken3 = object : SuperTypeToken<List<Carp>>() {}

//    println(superTypeToken1.equals(superTypeToken2))
//    println(superTypeToken1.equals(superTypeToken3))
    val superTypeSafeCage = SuperTypeSafeCage()
    superTypeSafeCage.putOne(superTypeToken2, listOf(GoldFish("금붕어"), GoldFish("금붕어2")))
//    val result = superTypeSafeCage.getOne(superTypeToken3)
    val result = superTypeSafeCage.getOne(superTypeToken2)
    println(result)
}

/**
 * 타입 안전 이종 컨테이너 패턴
 */
class SuperTypeSafeCage {
    private val animals: MutableMap<SuperTypeToken<*>, Any> = mutableMapOf()

    // 여기서 type: KClass<T> 를 타입 토큰이라고 한다.
    fun <T : Any> getOne(token: SuperTypeToken<T>): T {
        return this.animals[token] as T
    }

    fun <T : Any> putOne(token: SuperTypeToken<T>, animal: T) {
        animals[token] = animal
    }
}

// SuperTypeToken을 구현한 클래스가 인스턴스화 되지마자
// T 정보를 내부 변수에 저장해버린다.
// T <- List<Int>
abstract class SuperTypeToken<T> {
    val type: KType = this::class.supertypes[0].arguments[0].type!! // SuperTypeToken

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        other as SuperTypeToken<*>

        return type == other.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }
}
