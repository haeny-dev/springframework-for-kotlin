package com.haeny.lec12.java;

import com.haeny.lec12.kotlin.Person;

public class Lec12Main {

    public static void main(String[] args) {
//        Person.Companion.newBaby("ABC");

        Person.Factory.newBaby("ABC");
        Person.newBaby("ABC");
    }

}
