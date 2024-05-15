package com.example.javacodepractice.Task4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MyCollections {
    <K> Map<K, Integer> countOfElements(K[] array) {

        Map<K, Integer> mapForCountElements = new HashMap<>();

        int index = 0;

        Set<Map.Entry<K, Integer>> entrySet = mapForCountElements.entrySet();

        for (int i = 0; i < array.length; i++) {

            mapForCountElements.putIfAbsent(array[i], 0);
            Iterator<Map.Entry<K, Integer>> iterator = entrySet.iterator();

            for (int j = index; j < entrySet.size(); j++) {
                Map.Entry<K, Integer> entry = iterator.next();
                if (mapForCountElements.containsKey(array[i])) {
                    entry.setValue(entry.getValue() + 1);
                    index++;
                    break;
                }
            }
        }
        return mapForCountElements;
    }
}
