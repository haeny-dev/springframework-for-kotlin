package com.haeny.lec04;

public class Lec04Main {

    public static void main(String[] args) {
        JavaMoney money1 = new JavaMoney(1_000L);
        JavaMoney money2 = money1;
        JavaMoney money3 = new JavaMoney(1_000L);

//        if (money1.compareTo(money2) > 0) {/*
//            System.out.println("Money1이 Money2보다 금액이 큽니다.");
//        }*/

        System.out.println(money1 == money2);
        System.out.println(money1 == money3);
        System.out.println(money1.equals(money3));

        System.out.println(money1.plus(money2));
    }
}
