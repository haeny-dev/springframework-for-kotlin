package com.haeny.lec03

fun main() {
    val number1 = 3

    // 코틀린에서는 타입변환을 명시적으로 해주어야 한다.
    val number2: Long = number1.toLong()

    val nullableNumber1: Int? = 3
    val nonNullNumber2: Long = nullableNumber1?.toLong() ?: 0L

    printAgeIfPerson(null)
    printAgeIfPerson(Person("", 100))

    val person = Person("정주현", 31)
    val log = "사람의 이름은 ${person.name}이고 나이는 ${person.age}세 입니다."
    println(log)

    val str = """
        ABCD
        EFG
        ${person.name}
        ${person.age}
    """.trimIndent()
    println(str)

    val str2 = "ABC"
    println(str[0])
    println(str[1])
    println(str[2])
}

/*
fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        val person = obj // as Person 생략가능
        println(person.age)
        println(obj.age)    // 쌉가능
    }

    // Person 이 아니라면 이라는 표현도 가능하다
    if (obj !is Person) {
    }
}*/

fun printAgeIfPerson(obj: Any?) {
    val person = obj as? Person
    println(person?.age)
}
