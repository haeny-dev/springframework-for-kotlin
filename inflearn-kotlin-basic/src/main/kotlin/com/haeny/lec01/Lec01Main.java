package com.haeny.lec01;

import java.util.ArrayList;
import java.util.List;

public class Lec01Main {

    public static void main(String[] args) {
        long number1 = 10L; // (1)
        final long number2 = 10L; // (2)

        Long number3 = 1_000L; // (3)
        Person person = new Person("정주현"); // (4)

        final List<Integer> numbers = new ArrayList<>();
//        numbers = new ArrayList<>();  // 불가능
        numbers.add(1);
        numbers.add(2);
    }
}
