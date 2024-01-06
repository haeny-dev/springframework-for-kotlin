package com.haeny.lec15.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Lec15Main {

    public static void main(String[] args) {
        /* Array */
        int[] array = {100, 200};

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s %s", i, array[i]);
        }

        /* List */
        final List<Integer> numbers = Arrays.asList(100, 200);

        // 하나 가져오기
        System.out.println(numbers.get(0));

        // for each
        for (int number : numbers) {
            System.out.println(number);
        }

        // for loop
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%s %s", i, numbers.get(i));
        }

        /* Map */
        // JDK 8 까지
        Map<Integer, String> oldMap = new HashMap<>();
        oldMap.put(1, "MONDAY");
        oldMap.put(2, "TUESDAY");

        // JDK 9 부터
        Map.of(1, "MONDAY", 2, "TUESDAY");

        for (Integer key : oldMap.keySet()) {
            System.out.println(key);
            System.out.println(oldMap.get(key));
        }

        for (Entry<Integer, String> entry : oldMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
