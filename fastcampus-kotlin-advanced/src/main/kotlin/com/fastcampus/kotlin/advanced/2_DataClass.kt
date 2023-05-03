package com.fastcampus.kotlin.advanced

class NoneDataPerson(val name: String, val age: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NoneDataPerson

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + age
//        return result
//    }
}

/**
 * Data Class
 * - equals, hashCode, toString 들을 자동으로 재정의 해준다.
 * - copy 등의 메서드를 제공한다.
 */
data class Person(
    val name: String,
    val age: Int,
)

fun main() {
    val noneDataPerson1 = NoneDataPerson(name = "tony", age = 12)
    val noneDataPerson2 = NoneDataPerson(name = "tony", age = 12)

    val person1 = Person(name = "tony", age = 12)
    val person2 = Person(name = "tony", age = 12)

    println("noneDataPerson1 == noneDataPerson2 >> ${noneDataPerson1 == noneDataPerson2}")
    println("person1 == person2 >> ${person1 == person2}")

    val noneDatePersonSet = hashSetOf(noneDataPerson1)
    println("set.contains(noneDataPerson2) = ${noneDatePersonSet.contains(noneDataPerson2)}")

    println("noneDataPerson1.toString() = $noneDataPerson1")
    println("noneDataPerson2.toString() = $noneDataPerson2")

    val personSet = hashSetOf(person1)
    println("personSet.contains(person2) = ${personSet.contains(person2)}")

    /**
     * 불변 객체가 아닌 가변 객체일 경우 hash 관련 메서드에서 문제가 발생한다.
     * data class 의 copy 를 사용하면 객체의 불변성을 유지할 수 있다.
     */
    // person1.name = "strange"
    // println("personSet.contains(person1) = ${personSet.contains(person1)}")

    val copyPerson = person1.copy(name = "strange")
    println("copyPerson = $copyPerson")

    /**
     * componentN
     */
    println("이름=${person1.component1()}, 나이=${person1.component2()}")

    /**
     * 구조분해 할당
     */
    val (name, age) = person1
    println("이름=${name}, 나이=${age}")
}