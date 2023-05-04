package com.fastcampus.kotlin.advanced.scope_function

/**
 * 스코프 함수
 * - let      it      함수의 결과      확장함수
 * - run      this    함수의 결과      확장함수
 * - with     this    함수의 결과      X
 * - apply    this    컨텍스트 객체     확장함수
 * - also     it      컨텍스트 객체     확장함수
 *
 * 유의할 점
 * - 모든 기능들이 매우 유사하고, 목적들이 유사하다. >> 팀 내 컨벤션을 따라서 작성
 * - this 는 키워드이기 때문에 다른용도로 사용할 수 없지만, it 은 사용이 가능하다.
 * - 중첩으로 사용될 경우 it 을 사용하는 경우 어느 컨텍스트의 it 인지 구분이 안되기 때문에 명시해주는게 좋다.
 */

/**
 * let
 * - null 이 아닌 경우에 실행하는 경우에 주로 사용된다.
 * - 함수의 결과를 반환한다.
 */
fun main() {

    val str: String? = "안녕"

    val result: Int? = str?.let {
        println(it)

        // 이런 방식으로 사용 시 가독성이 떨어질 수 있음
        val abc: String? = "abc"
        abc?.let {

            val def: String? = "def"
            def?.let {
                println("abcdef가 null 아님")
            }

            // 이와 같은 방식으로 사용하는 것이 나을 수 있음
            if (!abc.isNullOrEmpty() && !def.isNullOrEmpty()) {

            }
        }

        1234
    }

    println(result)
}