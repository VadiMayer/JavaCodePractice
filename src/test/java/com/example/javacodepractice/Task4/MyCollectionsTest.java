package com.example.javacodepractice.Task4;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class MyCollectionsTest {
    @Test
    void countOfElementsInteger() {
        MyCollections myCollections = new MyCollections();
        Integer[] ints = new Integer[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        Map<Integer, Integer> map = myCollections.countOfElements(ints);
        System.out.println(map);
    }
}