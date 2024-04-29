package com.example.javacodepractice.model;

import java.util.Arrays;

public class MyStringBuilder {

    private String[] strings;

    private int count = 0;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    {
        strings = new String[DEFAULT_INITIAL_CAPACITY];
    }

    public void append(String str) {
        if (str == null) {
            System.out.println("Дай не null значение");
        }
        for (int i = 0; i < count; i++) {
            strings[count] = str;
            count++;
            if ((float) strings.length / DEFAULT_LOAD_FACTOR == count) {
                increasingSize();
            }
        }
    }

    private void increasingSize() {
        String[] stringsNewArray = new String[strings.length + count];
        System.arraycopy(strings, 0, stringsNewArray, 0, count);
        strings = stringsNewArray;
    }

    public void undo() {

    }

    @Override
    public String toString() {
        return Arrays.toString(strings);
    }
}
