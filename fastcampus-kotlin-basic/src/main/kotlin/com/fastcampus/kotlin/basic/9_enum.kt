package com.fastcampus.kotlin.basic

enum class PaymentStatus(
    val label: String
): Payable {
    UNPAID("미지불") {
        override fun isPayable() = true
    },
    PAID("지불완료") {
        override fun isPayable() = false
    },
    FAILED("지불실패") {
        override fun isPayable() = false
    },
    REFUNDED("환불") {
        override fun isPayable() = false
    };
}

interface Payable {
    fun isPayable(): Boolean
}

fun main() {
    println(PaymentStatus.UNPAID.label)

    if (PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능 상태 입니다.")
    }

    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)

    if (paymentStatus == PaymentStatus.PAID) {
        println("결제 완료 상태 입니다.")
    }

    for (status in PaymentStatus.values()) {
        println("[$status](${status.label})")
    }
}