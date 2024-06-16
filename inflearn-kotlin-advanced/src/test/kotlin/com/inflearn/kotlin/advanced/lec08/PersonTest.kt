package com.inflearn.kotlin.advanced.lec08

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PersonTest {
    private val person = Person()

    @Test
    fun isKimTest() {
        // when then
        assertTrue(person.apply { name = "김수한무" }.isKim)
    }

    @Test
    fun maskingNameTest() {
        // when then
        assertEquals("최**", person.apply { name = "최태현" }.maskingName)
    }
}
