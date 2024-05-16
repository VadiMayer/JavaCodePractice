package com.example.javacodepractice.Task4;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class MyCollectionsTest {
    @Test
    void countOfElementsInteger() {
        MyCollections myCollections = new MyCollections();
        Integer[] ints = new Integer[6000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 10) + 1;
        }
        Map<Integer, Integer> map = myCollections.countOfElements(ints);
        System.out.println(map);
    }

    @Test
    void countOfElementsStrings() {
        MyCollections myCollections = new MyCollections();
        String[] strings = new String[5000];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = (int) (Math.random() * 10) + 1 + " ";
        }
        Map<String, Integer> map = myCollections.countOfElements(strings);
        System.out.println(map);
    }
}