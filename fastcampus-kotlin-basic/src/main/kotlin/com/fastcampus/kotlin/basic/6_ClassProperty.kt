package com.fastcampus.kotlin.basic

class Coffee /*constructor*/(
    /**
     * 후행 쉼표를 사용할 수 있다.
     */
//        val name: String,
//        val price: Int,
//        val brand: String,

    /**
     * 코틀린에서는 var 로 선언 시 자동으로 getter, setter 를 생성해 준다.
     */
    var name: String = "",
    var price: Int = 0,
    var iced: Boolean = false,
){
    /**
     * Custom Getter
     */
    val brand: String
        get(){
            return "스타벅스"
        }

    /**
     * Custom Setter
     */
    var quantity: Int = 0
        set(value){
            if (value > 0) {    // 수량이 0 이상인 경우에만 할당
                field = value       // field 는 식별자 (백킹필드??)
            }
        }
}

class EmptyClass

fun main() {
    val coffee = Coffee()

    // 실제로 값을 얻어오고 설정하는 과정에서 getter 와 setter 를 이용해서 동작한다.
    coffee.name = "아이스 아메리카노"
    coffee.price = 2000
    coffee.quantity = 2
    coffee.iced = true

    if (coffee.iced) {
        print("[ICED]")
    }

    println("${coffee.brand} ${coffee.name} ${coffee.quantity}개 가격은 ${coffee.quantity * coffee.price}원")
}