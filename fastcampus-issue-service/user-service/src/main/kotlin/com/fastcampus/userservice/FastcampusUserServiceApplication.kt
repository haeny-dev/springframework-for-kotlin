package com.fastcampus.userservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class FastcampusUserServiceApplication

fun main(args: Array<String>) {
    runApplication<FastcampusUserServiceApplication>(*args)
}