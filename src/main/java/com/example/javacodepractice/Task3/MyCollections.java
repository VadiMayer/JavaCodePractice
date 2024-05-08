package com.example.javacodepractice.Task3;

public class MyCollections {
    public <T> T[] filter(T[] array, Filter filterClass) {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[array.length];

        for (int i = 0; i < array.length; i++) {
            T el = (T) filterClass.apply(array[i]);
            if (el == null) {
                continue;
            }
            newArray[i] = el;
        }
        return newArray;
    }
}
