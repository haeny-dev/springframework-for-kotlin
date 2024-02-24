package com.fastcampuse.javatokotlin.gettersetter

fun main() {
    // Java
    val person = Person()
    person.setName("정주현")
    person.setAge(33)
    person.setAddress("지구")

    println(person.getName())
    println(person.getAge())

    // Kotlin
    val person2 = Person()
    person2.name = "정주현"
    person2.age = 33

    println(person.name)
    println(person.age)

    // property 가 없음에도 getter 메서드라면 프로퍼티처럼 사용 할 수 있음
    println(person.uuid)

    // setter 가 있음에도 컴파일 오류가 나는 케이스
    // person.address = ""
    person.setAddress("")

    person2.setAddress("지구")
    println(person2.myAddress())
}