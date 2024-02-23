package com.fastcampuse.javatokotlin.gettersetter;

import java.time.LocalDate;

public class JavaGetterSetterExample {

    public static void main(String[] args) {
        Student student = new Student();

//        student.setName("정주현"); @JvmField 애노테이션 사용 시 불가
        student.name = "정주현";
        student.setBirthDate(LocalDate.of(1992, 10, 4));

//        System.out.println(student.getName());
        System.out.println(student.name);
        System.out.println(student.getBirthDate());

//        student.setAge(5); set 할 수 없음
        System.out.println(student.getAge());

//        student.setGrade("z"); set 할 수 없음
        student.changeGrade("A");
        System.out.println(student.getGrade());
    }
}
