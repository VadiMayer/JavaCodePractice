package com.example.javacodepractice.Task3;

public class FilterOnlyPositiveNumbers implements Filter {
    @Override
    public Object apply(Object o) {
        if ((int) o < 0) {
            return null;
        } else
            return o;
    }
}
