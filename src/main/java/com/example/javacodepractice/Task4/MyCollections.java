package com.example.javacodepractice.Task4;

import java.util.HashMap;
import java.util.Map;

class MyCollections {
    <K> Map<K, Integer> countOfElements(K[] array) {

        Map<K, Integer> mapForCountElements = new HashMap<>();

        for (K element : array) {
            mapForCountElements.put(element, mapForCountElements.getOrDefault(element, 0) + 1);
        }

        return mapForCountElements;
    }
}
