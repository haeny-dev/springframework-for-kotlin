package com.inflearn.kotlin.coroutine.lec03

import com.inflearn.kotlin.coroutine.lec01.printWithThread
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 코루틴 빌더
 * 1) runBlocking
 * - 새로운 코루틴을 만들고 루틴 세계와 코루틴 세계를 이어준다.
 * - runBlocking 블록이 끝날때 까지 블록킹한다.
 *
 * 2) launch
 * - 반환값이 없는 코드를 실행
 * - 코루틴을 제어할 수 있는 객체 Job 을 반환
 *
 * Job 객체 활용
 * - start(): 시작
 * - cancel(): 취소
 * - join(): 코루틴이 완료될 때까지 대기
 *
 * 3) async
 * - 주어진 함수의 실행 결과를 반활할 수 있다.
 * - 코루틴을 제어할 수 있는 객체 Deferred 를 반환
 * - 여러 API를 동시에 호출하여 소요시간을 최소화할 수 있다.
 * - callback 을 이용하지 않고 동기 방식으로 코드를 작성할 수 있다.
 * - CoroutineStart.LAZY 옵션을 사용하면, await() 함수를 호출 했을 때 계산 결과를 계속 기다린다.
 */
fun main() = runBlocking {
    val time = measureTimeMillis {
        val job1 = async { apiCall1() }
        val job2 = async { apiCall2(job1.await()) }

        printWithThread(job2.await())
    }

    printWithThread("소요 시간 : $time ms")
}

suspend fun apiCall2(num: Int): Int {
    delay(1_000L)
    return num + 2
}

fun example6() = runBlocking {
    val time = measureTimeMillis {
        val job1 = async { apiCall1() }
        val job2 = async { apiCall2() }

        printWithThread(job1.await() + job2.await())
    }

    printWithThread("소요 시간 : $time ms")
}

suspend fun apiCall1(): Int {
      delay(1_000L)
    return 1
}

suspend fun apiCall2(): Int {
    delay(1_000L)
    return 2
}

fun example5() = runBlocking {
    val job = async {
        3 + 5
    }

    val result = job.await() // await: async 의 결과를 가져오는 함수
    printWithThread(result)
}

fun example4() = runBlocking {
    val job1 = launch {
        delay(1_000L)
        printWithThread("Job 1")
    }

    job1.join()

    val job2 = launch {
        delay(1_000L)
        printWithThread("Job 2")
    }
}

fun example3() = runBlocking {
    val job = launch {
        (1..5).forEach {
            printWithThread(it)
            delay(500)
        }
    }

    delay(1_000L)
    job.cancel()
}

fun example2(): Unit = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        printWithThread("Hello Launch")
    }

    delay(1_000L)
    job.start()
}

fun example1() {
    runBlocking {
        printWithThread("START")
        launch {
            delay(2_000L)
            printWithThread("LAUNCH END")
        }
    }

    printWithThread("END")
}