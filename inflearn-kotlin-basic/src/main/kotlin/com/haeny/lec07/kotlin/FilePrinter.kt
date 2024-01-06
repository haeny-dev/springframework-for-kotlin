package com.haeny.lec07.kotlin

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FilePrinter {

    /**
     * 코틀린에서는 try-with-resources 구문은 없고,
     * use 라는 함수를 사용해야 한다.
     */
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }

    /**
     * throws IOException 을 붙여주지 않는다.
     *
     * 코틀린에서는 CheckedException 과 UncheckedException 을 구분하지 않는다.
     * 모두 UncheckedException 이다.
     */
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }
}