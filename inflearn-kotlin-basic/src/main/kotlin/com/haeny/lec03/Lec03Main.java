package com.haeny.lec03;

public class Lec03Main {

    public static void main(String[] args) {
        Person person = new Person("정주현", 31);
        String log = String.format("사람의 이름은 %s이고 나이는 %s세 입니다.", person.getName(), person.getAge());
        System.out.println(log);

        StringBuilder builder = new StringBuilder();
        builder.append("사람의 이름은 ")
            .append(person.getName())
            .append("이고 나이는 ")
            .append(person.getAge())
            .append("세 입니다.");

        System.out.println(builder);
    }

    public static void printAgeIfPerson(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            System.out.println(person.getAge());
        }
    }

}
