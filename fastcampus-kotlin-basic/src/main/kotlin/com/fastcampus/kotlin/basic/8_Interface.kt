package com.fastcampus.kotlin.basic

class Product(val name: String, val price: Int)

interface Wheel {
    fun roll()
}

interface Cart : Wheel {
    var coin: Int

    // 인터페이스의 경우 백킹필드에 접근할 수 없다.
    // Getter 를 사용해서 특정값을 반환할 수 있다.
    val weight: String
        get() = "20KG"

    fun add(product: Product)

    // 디폴트 함수
    fun rent() {
        if (coin > 0) {
            println("카트를 대여합니다.")
        }
    }

    override fun roll() {
        println("카트가 굴러갑니다.")
    }

    fun printId() = println("1234")
}

interface Order {
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다.")
    }

    fun printId() = println("5678")
}

class MyCart(
    override var coin: Int
) : Cart, Order {

    override fun add(product: Product) {
        if (coin <= 0) {
            println("코인을 넣어주세요")
        } else {
            println("${product.name}이(가) 카트에 추가되었습니다.")
        }

        // 주문하기
        super<Order>.add(product)
    }

    /**
     * 디폴트 함수가 겹치는 경우에는 재정의를 강제한다
     */
    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name = "장난감", price = 1000))
    cart.printId()
}