package com.inflearn.kotlin.advanced.lec01

abstract class Animal(
    val name: String,
)

abstract class Fish(name: String): Animal(name)

class GoldFish(name: String): Fish(name)

class Carp(name: String): Fish(name)