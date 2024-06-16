package com.inflearn.kotlin.advanced.lec25

fun main() {
    val key = Key("비밀 번호")

//    val userId = 1L
//    val bookId = 2L
//    handle(bookId, userId)

//    val inlineUserId = Id<User>(1L)
//    val inlineBookId = Id<Book>(2L)
//    handle(inlineUserId, inlineBookId)

    try {
    } catch (e: Exception) {
        when (e) {
            is AException,
            is BException -> TODO()
            is CException -> TODO()
        }
        throw e
    }
}

/**
 * Try catch 구문에서 여러 예외를 받고 싶은 경우
 */
fun logic(n: Int) {
    when {
        n > 0 -> throw AException()
        n == 0 -> throw BException()
    }
    throw CException()
}

class AException : RuntimeException()
class BException : RuntimeException()
class CException : RuntimeException()

/**
 * 인라인 클래스 (@JvmInline + value 키워드)
 * => 인라인 클래스의 프로퍼티가 그대로 전달된다.
 * => 인라인 클래스는 프로퍼티를 하나만 가지고 있어야 한다.
 * => 같은 타입의 식별자를 다수 사용할 경우
 */
@JvmInline
value class Key(val key: String)

class User(
    val id: Id<User>,
    val name: String,
)

class Book(
    val id: Id<Book>,
    val author: String,
)

fun handle(userId: Id<User>, bookId: Id<Book>) {
}

@JvmInline
value class Id<T>(val id: Long)

@JvmInline
value class Number(val num: Long) {
    // 값 객체를 만들어서 해당 관련 로직을 한데 모아서 관리할 수 있음
    init {
        require(num in 1..10)
    }
}

/**
 * 꼬리 재귀 함수 최적화 => tailrec
 * - 스택이 쌓이는 재귀 함수 호출을 루프로 변경해 컴파일 시킨다.
 */
// 꼬리 재귀 함수
tailrec fun factorialV2(n: Int, curr: Int = 1): Int {
    return if (n <= 1) {
        curr
    } else {
        factorialV2(n - 1, n * curr)
    }
}
