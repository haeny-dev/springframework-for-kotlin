package com.inflearn.kotlin.coroutine.lec04

import com.inflearn.kotlin.coroutine.lec01.printWithThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException

/**
 * 필요하지 않은 코루틴을 적절히 취소해 컴퓨터 자원을 아껴야 한다.
 * cancel() 을 통해서 취소하면 되지만, 코루틴도 협조해 주어야 한다.
 *
 * 취소에 협조하는 방법1
 * - delay(), yield() 같은 kotlinx.coroutines 패키지의 suspend 함수 사용
 * 취소에 협조하는 방법2
 * - 코루틴 스스로 본인의 상태를 확인해서 취소 요청을 받았으면,
 * => CancellationException 을 던진다.
 *
 * 사실 delay 같은 함수도 CancellationException 을 던져서 취소하고 있음
 * try catch 로 잡으면 취소되지 않을 수 있음
 */

fun main() = runBlocking {
    val job = launch {
        try {
            delay(1_000L)
        } catch (e: CancellationException) {
            // 아무것도 안한다.
        }

        printWithThread("delay 에 의해 취소되지 않았다!")
    }

    delay(100L)
    printWithThread("취소 시작")
    job.cancel()
}

fun example2() = runBlocking {
    val job = launch(Dispatchers.Default) { // 코루틴을 다른 스레드에 배정
        var i = 1
        var nextPrintTime = System.currentTimeMillis()
        while(i <= 5) {
            if (nextPrintTime <= System.currentTimeMillis()) {
                printWithThread("${i++}번째 출력!")
                nextPrintTime += 1_000L
            }

            if (!isActive) {    // 현재 코루틴이 활성화 되어 있는지, 취소 신호를 받았는지 확인할 수 있음
                throw CancellationException()
            }
        }
    }

    delay(100L)
    job.cancel()
}

fun example1(): Unit = runBlocking {
    val job1 = launch {
        delay(1_000L)
        printWithThread("Job 1")
    }

    val job2 = launch {
        delay(1_000L)
        printWithThread("Job 2")
    }

    delay(100)
    job1.cancel()
}