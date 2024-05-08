package com.example.javacodepractice.Task3;

import java.lang.reflect.Array;

public class MyCollections {
    public <T> T[] filter(T[] array, Filter filterClass) {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);

        for (int i = 0; i < array.length; i++) {

            @SuppressWarnings("unchecked")
            T el = (T) filterClass.apply(array[i]);
            if (el == null) {
                continue;
            }
            newArray[i] = el;
        }

        return newArray;
    }
}
