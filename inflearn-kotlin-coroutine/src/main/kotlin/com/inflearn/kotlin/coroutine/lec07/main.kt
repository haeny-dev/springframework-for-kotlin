package com.inflearn.kotlin.coroutine.lec07

import com.inflearn.kotlin.coroutine.lec01.printWithThread
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

/**
 * CoroutineScope 과 CoroutineContext
 * - launch 와 async 는 CoroutineScope 의 확장함수이다
 * -> 직접 CoroutineScope 을 만들면 runBlocking 이 없어도 사용 가능하다.
 *
 * CoroutineScope 의 주요역할
 * -> CoroutineContext 라는 데이터를 보관하는 것
 * -> CoroutineContext 란 코루틴과 관련된 여러가지 데이터를 갖고 있다.
 * -> 코루틴 이름, CoroutineExceptionHandler, 코루틴 그 자체, CoroutineDispatcher ....
 *
 * Dispatcher
 * -> 코루틴이 어떤 스레드에 배정될지를 관리하는 역할
 *
 * CoroutineScope: 코루틴이 탄생할 수 있는 영역
 * CoroutineContext: 코루틴과 관련된 데이터를 보관
 */
suspend fun example() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        delay(1_000L)
        printWithThread("Job 1")
    }

    job.join()
}

/**
 * 클래스 내부에서 독립적인 CoroutineScope 관리
 * -> 해당 클래스에서 사용하던 코루틴을 한 번에 종료할 수 있다.
 */
class AsyncLogic {
    private val scope = CoroutineScope(Dispatchers.Default)

    fun doSomething() {
        scope.launch {
            // 무언가 코룬틴이 시작되어 작업
        }
    }

    fun destroy() {
        scope.cancel()
    }
}

/**
 * CoroutineContext
 * -> Map + Set 을 합쳐놓은 형태
 * -> element(key-value) 로 데이터를 저장, 같은 key 의 데이터는 유일
 */
suspend fun example2() {
//    CoroutineName("나만의 코루틴") + Dispatchers.Default
    val job = CoroutineScope(Dispatchers.Default).launch {
        delay(1_000L)
        printWithThread("Job 1")
//        coroutineContext.minusKey()
    }

    job.join()
}

/**
 * CoroutineDispatcher
 * - 코루틴을 스레드에 배정하는 역할
 *
 * Dispatchers.Default
 * -> 가장 기본적인 디스패처, CPU 자원을 많이 쓸 때 권장
 * -> 별다른 설정이 없으면 이 디스패처가 사용된다.
 *
 * Dispatchers.IO
 * -> I/O 작업에 최적화된 디스패처
 *
 * Dispatchers.Main
 * -> 보통 UI 컴포넌트를 조작하기 위한 디스패처
 * 특정 의존성을 갖고 있어야 정상적으로 활용할 수 있다.
 *
 * ExecutorService(Java) 를 디스패처로
 * -> asCoroutineDispatcher() 확장함수 활용
 */
fun main() {
    val threadPool = Executors.newSingleThreadExecutor()
    CoroutineScope(threadPool.asCoroutineDispatcher()).launch {
        printWithThread("새로운 코루틴")
    }
}