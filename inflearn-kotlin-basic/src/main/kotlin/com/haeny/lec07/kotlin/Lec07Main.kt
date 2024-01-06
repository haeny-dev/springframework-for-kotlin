package com.haeny.lec07.kotlin

import java.lang.IllegalArgumentException
import kotlin.NumberFormatException

fun main() {

}

fun parseIntOrThrowV2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 $str 는 숫자가 아닙니다.")
    }
}