package com.inflearn.kotlin.coroutine.lec05

import com.inflearn.kotlin.coroutine.lec01.printWithThread
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Job(코루틴) 의 Life Cycle
 *
 * NEW -> Active     ->      Completing -> Completed
 *           ㄴ-> Cancelling   <-
 *                  ㄴ-> Cancelled
 */

/**
 * 코루틴 취소 예외 정리
 * 1) 발생한 예외가 CancellationException 인 경우
 * - 취소로 간주하고 부모 코루틴에게 전파 X
 *
 * 2) 그 외 다른 예외가 발생한 경우
 * - 실패로 간주하고 부모 코루틴에게 전파 O
 */

/**
 * 예외를 다루는 방법2
 * CoroutineExceptionHandler
 * 주의할 점
 * - launch 에만 적용 가능
 * - 부모 코루틴이 있으면 동작하지 않는다.
 */
fun main(): Unit = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        printWithThread("에외")
    }

    val job = CoroutineScope(Dispatchers.Default).launch(exceptionHandler) {
        throw IllegalArgumentException()
    }

    delay(1_000L)
}

/**
 * 예외를 다루는 방법1
 * try catch finally
 */
fun example3(): Unit = runBlocking {
    val job = launch {
        try {
            throw IllegalArgumentException()
        } catch (e: IllegalArgumentException) {
            printWithThread("정상 종료")
        }
    }
}

/**
 * 자식 코루틴의 예외는 부모에게 전파된다.
 * 자식 코루틴의 예외를 부모에게 전파하지 않기 위해서 루트 코루틴을 생성하는 것 이외에는
 * SupervisorJob 을 활용
 */
fun example2(): Unit = runBlocking {
    val job = async(SupervisorJob()) {
        throw IllegalArgumentException()
    }

    delay(1_000L)
}

/**
 * launch: 예외가 발생하면, 예외를 출력하고 코루틴이 종료
 * async: 예외가 발생해도, 예외를 출력하지 않음
 * 예외를 확인하려면 await() 이 필요함
 */
fun example1(): Unit = runBlocking {
    val job = CoroutineScope(Dispatchers.Default).async {
        throw IllegalArgumentException()
    }

    delay(1_000L)
    job.await()
}