package com.haeny.lec09.java;

public class JavaPerson {

    private final String name;
    private int age;

    public JavaPerson(String name, int age) {
        this.name = name;
        this.age = age;

        if (this.age <= 0) {
            throw new IllegalArgumentException(String.format("나이는 %s일 수 없습니다.", age));
        }
    }

    public JavaPerson(String name) {
        this(name, 1);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdult() {
        return this.age >= 20;
    }
}
