package com.example.javacodepractice.Task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyCollectionsTest {
    Integer[] numbers;

    @BeforeEach
    void createArray() {
        numbers = new Integer[100];
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                numbers[i] = -i;
            } else
                numbers[i] = i;
        }
    }

    @Test
    void filter() {
        MyCollections myCollections = new MyCollections();
        FilterOnlyPositiveNumbers filterOnlyPositiveNumbers = new FilterOnlyPositiveNumbers();
        Integer[] array = (Integer[]) myCollections.filter(numbers, filterOnlyPositiveNumbers);
        System.out.println(Arrays.toString(array));
    }
}