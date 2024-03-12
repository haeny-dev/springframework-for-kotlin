package com.fastcampus.userservice.global.exception

sealed class ServerException(
    val code: Int,
    override val message: String,
) : RuntimeException(message){
}