package com.fastcampus.kotlin.advanced

fun getStr(): Nothing = throw Exception("예외 발생 기본 값으로 초기화")

fun main() {
    // val result = try {
    //     getStr()
    // } catch (e: Exception) {
    //     println(e.message)
    //     "기본값"
    // }
    //
    // println(result)

    val result = runCatching { getStr() }
        .getOrElse { println(it.message); "기본값" }
    println(result)

    val getOrNull = runCatching { "성공" }.getOrNull()
    println(getOrNull)

    val exceptionOrNull = runCatching { getStr() }.exceptionOrNull()
    exceptionOrNull?.let {
        println(it.message)
        // throw it
    }

    val getOrDefault = runCatching { getStr() }.getOrDefault("기본값")
    println(getOrDefault)

    val getOrElse = runCatching { getStr() }
        .getOrElse { println(it.message); "기본값" }
    println(getOrElse)

    val getOrThrow = runCatching { "성공" }.getOrThrow()
    println(getOrThrow)

    val map = runCatching { "안녕" }.map { "${it}하세요" }.getOrThrow()
    println(map)

    val mapOrDefault = runCatching { "안녕" }
        .mapCatching { throw Exception("예외") }
        .getOrDefault("기본값")
    println(mapOrDefault)

    val recover = runCatching { getStr() }
        .recover { "복구" }
        .getOrNull()
    println(recover)

    val recoverCatching = runCatching { getStr() }
        .recoverCatching { throw Exception("예외") }
        .getOrDefault("복구")
    println(recoverCatching)

}