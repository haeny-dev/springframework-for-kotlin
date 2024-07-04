package com.inflearn.kotlin.coroutine.lec06

import com.inflearn.kotlin.coroutine.lec01.printWithThread
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Job 의 Life Cycle 에서 Completing 과 Completed 가 나눠져 있는 이유
 * - 부모 코루틴이 자식 코루틴을 모두 기다려야 하기 때문
 *
 * 자식 코루틴을 기다리다가 예외가 발생한다면
 * -> 예외가 부모로 전파되고 다른 자식 코루틴에게 취소 요청을 보낸다
 *
 * 부모 - 자식 관계의 코루틴이 한 몸처럼 움직이는 것을
 * -> Structured Concurrency 라고 한다
 * -> 수많은 코루틴이 유실되거나 누수되지 않도록 보장한다.
 * -> 코드 내의 에러가 유실되지 않고 적절히 보고될 수 있도록 보장한다.
 *
 * 정리
 * -> 자식 코루틴에서 예외가 발생할 경우 Structured Concurrency 에 의해 부모 코루틴이 취소되고,
 * 부모 코루틴의 다른 자식 코루틴들도 취소된다.
 * -> 자식 코루틴에서 예외가 발생하지 않더라도, 부모 코루틴이 취소되면, 자식 코루틴들이 취소된다.
 * -> 단, CancellationException 은 정상적인 취소로 간주하기 때문에
 * 부모 코루틴에게 전파되지 않고, 부모 코루틴의 다른 자식 코루틴을 취소시키지도 않는다.
 */
fun main(): Unit = runBlocking {
    launch {
        delay(600L)
        printWithThread("A")
    }

    launch {
        delay(500L)
        throw IllegalArgumentException("코루틴 실패")
    }
}