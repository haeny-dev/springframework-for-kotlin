package com.haeny.lec20.kotlin

import com.haeny.lec09.kotlin.Person
import com.haeny.lec14.kotlin.PersonDto

fun main() {

    val person = Person("정주현", 100)

    val value1 = person.let { it.age }      // age
    val value2 = person.run { this.age }    // age
    val value3 = person.also { it.age }     // person
    val value4 = person.apply { this.age }  // person

    with(person) {
        println(name)
        println(age)
    }

    /* let */
    // 하나 이상의 함수를 call chain 결과로 호출할 때
    val strings = listOf("APPLE", "CAR")
    strings.map { it.length }
        .filter { it > 3 }
        .let(::println)

    // non-null 값에 대해서만 code block 을 실행시킬 때
    val str: String? = null
    val length = str?.let {
        println(it.uppercase())
        it.length
    }

    // 일회성으로 제한된 영역에 지역변수를 만들 때
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first()
        .let { firstItem ->
            if(firstItem.length >= 5) firstItem else "!$firstItem!"
        }.uppercase()

    println(modifiedFirstItem)

    /* run */
    // 객체 초기화와 반환 값의 계산을 동시에 해야 할 때
    // 객체를 만들어 DB에 바로 저장하고, 그 인스턴스를 활용할 때
//    val savePerson = Person("정주현2", 100).run { personRepository::save }

    /* also */
    // 객체를 수정하는 로직이 call chain 중간에 필요할 때
    mutableListOf("one", "two", "three")
        .also { println("The list elements before adding new one: $it") }
        .add("four")

    val mutableNumbers = mutableListOf("one", "two", "three")
    println("The list elements before adding new one: $mutableNumbers")
    mutableNumbers.add("four")

    /* with */
    // 특정 객체를 다른 객체로 변환해야 하는데,
    // 모듈 간의 의존성에 의해 정적 팩토리 혹은 toClass 함수를 만들기 어려울 때
    return with(person){
        PersonDto(
            name = name,
            age = age
        )
    }

    /* 가독성 */
    // 1번 코드
    if (person != null && person.isAdult) {
//        view.showPerson(person)
    } else {
//        view.showError()
    }

    // 2번 코드
    person?.takeIf { it.isAdult }
//        ?.let { view::showPerson }
//        ?: view.showError()
}

/* apply */
// 객체 설정을 할 때에 객체를 수정하는 로직이 call chain 중간에 필요할 떄
// Test Fixture 만들 때
fun createPerson(
    name: String,
    age: Int,
    hobby: String,
): Person{
    return Person(
        name = name,
        age = age
    ).apply {
//        this.hobby = hobby
    }
}

fun printPerson(person: Person?) {
    person?.let {
        println(it.name)
        println(it.age)
    }

//    if (person != null) {
//        println(person.name)
//        println(person.age)
//    }
}