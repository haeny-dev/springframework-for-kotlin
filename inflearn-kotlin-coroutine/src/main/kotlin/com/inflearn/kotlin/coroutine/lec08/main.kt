package com.inflearn.kotlin.coroutine.lec08

import com.inflearn.kotlin.coroutine.lec01.printWithThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.future.await
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import java.util.concurrent.CompletableFuture

/**
 * suspend 함수는 코루틴이 중지 되었다가 재개 될 수 있는 지점 (suspension point)
 * -> 여러 비동기함수 라이브러리를 사용할 수 있다.
 */
fun example(): Unit = runBlocking {
    launch {
        a()
        b()
    }

    launch {
        c()
    }
}

suspend fun a() {
    printWithThread("A")
}

suspend fun b() {
    printWithThread("B")
}

suspend fun c() {
    printWithThread("C")
}

//fun main(): Unit = runBlocking {
//    val result1 = async {
//        call1()
//    }
//
//    val result2 = async {
//        call2(result1.await())
//    }
//
//    printWithThread(result2.await())
//}

fun example2(): Unit = runBlocking {
    val result1 = call1()
    val result2 = call2(result1)
    printWithThread(result2)
}

suspend fun call1(): Int {
    return CoroutineScope(Dispatchers.Default).async {
        Thread.sleep(1_000L)
        100
    }.await()
}

suspend fun call2(num: Int): Int {
    return CompletableFuture.supplyAsync {
        Thread.sleep(1_000L)
        num * 2
    }.await()
}

interface AsyncCaller {
    suspend fun call()
}

class AsyncCallerImpl : AsyncCaller {
    override suspend fun call() {
        TODO("Not yet implemented")
    }
}

/**
 * coroutineScope
 * - 추가적인 코루틴을 만들고, 주어진 함수 블록이 바로 실행된다.
 * - 만들어진 코루틴이 모두 완료되면 다음 코드로 넘어간다.
 */
fun coroutineScopeExample(): Unit = runBlocking {
    printWithThread("START")
    printWithThread(calcalateResult())
    printWithThread("END")
}

suspend fun calcalateResult(): Int = coroutineScope {
    val num1 = async {
        delay(1_000L)
        10
    }

    val num2 = async {
        delay(1_000L)
        20
    }

    num1.await() + num2.await()
}

/**
 * withContext
 * - coroutineScope 과 기본적으로 유사하다.
 * - context 에 변화를 주는 기능이 추가적으로 있다.
 */
fun withContextExample(): Unit = runBlocking {
    printWithThread("START")
    printWithThread(calcalateResult2())
    printWithThread("END")
}

suspend fun calcalateResult2(): Int = withContext(Dispatchers.Default) {
    val num1 = async {
        delay(1_000L)
        10
    }

    val num2 = async {
        delay(1_000L)
        20
    }

    num1.await() + num2.await()
}

/**
 * withTimeout / withTimeoutOrNull
 * - coroutineScope 과 기본적으로 유사하다
 * - 주어진 시간 안에 새로 생긴 코루틴이 완료되어야 한다.
 * - 주어진 시간 안에 코루틴이 완료되지 못하면 예외를 던지거나 null 을 반환하게 된다.
 */
fun main(): Unit = runBlocking {
    val result = withTimeout(1_000L) {
        delay(1_500L)
        10 + 20
    }

    printWithThread(result)
}