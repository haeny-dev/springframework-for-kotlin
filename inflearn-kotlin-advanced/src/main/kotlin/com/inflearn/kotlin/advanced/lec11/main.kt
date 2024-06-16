package com.inflearn.kotlin.advanced.lec11

import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun main() {
//    val status: String by object : ReadOnlyProperty<Person3, String> {
//        private var isGreen: Boolean = false
//
//        override fun getValue(thisRef: Person3, property: KProperty<*>): String {
//            return if (isGreen) {
//                "Happy"
//            } else {
//                "Sad"
//            }
//        }
//    }
    Person5()
}

class Person5 {
    val name by DelegateProvider("정주현") // 정상동작
    val country by DelegateProvider("한국") // 정상동작 X
}

class DelegateProvider(
    private val initValue: String,
) : PropertyDelegateProvider<Any, DelegateProperty> {
    override fun provideDelegate(thisRef: Any, property: KProperty<*>): DelegateProperty {
        if (property.name != "name") {
            throw IllegalArgumentException("name 만 연결 가능합니다. property name: ${property.name}")
        }

        return DelegateProperty(initValue)
    }
}

class DelegateProperty(
    private val initValue: String,
) : ReadOnlyProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return initValue
    }
}

class LazyInitProperty<T>(val init: () -> T) : ReadOnlyProperty<Any, T> {
    private var _value: T? = null
    val value: T
        get() {
            if (_value == null) {
                this._value = init()
            }
            return _value!!
        }

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        TODO("Not yet implemented")
    }
}
