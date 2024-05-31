package com.example.javacodepractice.Task9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        Optional<Integer> result = numbers.stream()
                .map(n -> {
                    System.out.println("Mapping element: " + n);
                    return n * 2;
                })
                .findFirst();

        System.out.println("Result: " + result.orElse(null));
    }
}
