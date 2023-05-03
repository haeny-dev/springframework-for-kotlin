package com.fastcampus.kotlin.advanced

/**
 * Sealed Class
 * - 같은 패키지 및 모듈에 있어야지만 하위 클래스를 정의 할 수 있다.
 */
sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(
    override val name: String
) : Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자입니다 ${language}를 사용합니다.")
    }
}

data class FrontendDeveloper(
    override val name: String
) : Developer() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자입니다 ${language}를 사용합니다.")
    }
}

data class AndroidDeveloper(
    override val name: String
) : Developer() {
    override fun code(language: String) {
        println("저는 안드로이드 개발자입니다 ${language}를 사용합니다.")
    }
}

data class IosDeveloper(
    override val name: String
) : Developer() {
    override fun code(language: String) {
        println("저는 IOS 개발자입니다 ${language}를 사용합니다.")
    }
}

object OtherDeveloper : Developer() {
    override val name: String = "익명"
    override fun code(language: String) {}
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    // else 를 사용하지 않고 is OtherDeveloper 와 같이 선언할 경우
    // 하위 클래스를 정의할 경우 컴파일 에러를 발생시켜준다.
    fun add(developer: Developer) = when (developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        is AndroidDeveloper -> pool[developer.name] = developer
        is IosDeveloper -> pool[developer.name] = developer
        is OtherDeveloper -> println("지원하지 않는 개발자입니다.")
        // else -> {
        //     println("지원하지 않는 개발자입니다.")
        // }
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name = "토니")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name = "카즈야")
    DeveloperPool.add(frontendDeveloper)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("카즈야"))
}