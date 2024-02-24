package com.fastcampuse.javatokotlin.jvmstatic;

public class JvmStaticExample {
    public static void main(String[] args) {
//        String hello = HelloClass.Companion.hello();
//        String hi = HiObject.INSTANCE.hi();

        HelloClass.hello();
        HiObject.hi();
    }
}
