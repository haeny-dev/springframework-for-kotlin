package com.fastcampus.kotlin.basic

fun main() {

    // val a: String = null     // 컴파일 에러 발생

    // var b: String = "aabbcc"
    // b = null      // 컴파일 에러 발생

    /**
     * Nullable 한 Type
     */
    var a: String? = null
    println(a?.length)

    val b: Int = if (a != null) a.length else 0
    println(b)

    /**
     * 엘비스 연산자
     */
    val c = a?.length ?: 0
    println(c)

    val nullableStr = getNullStr()
    val nullableStrLength = nullableStr?.length ?: "null인 경우 반환".length
    println(nullableStrLength)

    val length = getLengthIfNotNull(null)
    println(length)

//    throw NullPointerException()

//    val c: String? = null
//    val d = c!!.length
}

fun getNullStr(): String? = null

fun getLengthIfNotNull(str: String?) = str?.length ?: 0