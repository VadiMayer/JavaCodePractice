package com.example.javacodepractice.Task3;

public class FilterOnlyPositiveNumbers implements Filter {
    @Override
    public Object apply(Object o) {
        if ((Integer) o < 0) {
            return null;
        } else
            return o;
    }
}
