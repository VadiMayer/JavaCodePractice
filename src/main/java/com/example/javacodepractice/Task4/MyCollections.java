package com.example.javacodepractice.Task4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MyCollections {
    <K, E, T> Map<K, E> countOfElements(T[] array) {
        Map<K, E> mapForCountElements = new HashMap<>();
        for (T e : array) {
            mapForCountElements.putIfAbsent((K) e, (E) Integer.valueOf(1));
            if (mapForCountElements.containsKey((K) e)) {

            }
        }
        return mapForCountElements;
    }
}
