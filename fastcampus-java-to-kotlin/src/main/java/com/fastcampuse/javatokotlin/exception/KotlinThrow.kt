package com.fastcampuse.javatokotlin.exception

import java.io.IOException
import kotlin.jvm.Throws

class KotlinThrow {
    @Throws(IOException::class) // throws IOException 과 같음
    fun throwIOException() {
        throw IOException("CheckedException 인 IOException 발생")
    }
}

fun main() {
    val javaThrow = JavaThrow()
    javaThrow.throwIOException()

    val kotlinThrow = KotlinThrow()
    kotlinThrow.throwIOException()
}