package com.example.javacodepractice.Task8;

import java.util.List;

public class ComplexTask {
    private final List<Integer> data;
    private int result;

    public ComplexTask(List<Integer> data) {
        this.data = data;
    }

    public int execute() {
        result = data.stream().mapToInt(Integer::intValue).sum();
        return result;
    }
}
