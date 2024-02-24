package com.fastcampuse.javatokotlin.extensions;

public class ExtensionExample {

    public static void main(String[] args) {
        // 사용 불가
//        "ABCD".first();
//        "ABCD".addFirst('Z');

        char first = ExtensionsExampleKt.first("ABCD");
        System.out.println(first);

        String addFirst = ExtensionsExampleKt.addFirst("ABCD", 'Z');
        System.out.println(addFirst);
    }
}
