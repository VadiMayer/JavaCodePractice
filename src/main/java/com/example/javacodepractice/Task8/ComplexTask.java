package com.example.javacodepractice.Task8;

import java.util.List;

public class ComplexTask {
    private final List<Integer> data;

    public ComplexTask(List<Integer> data) {
        this.data = data;
    }

    public int execute() {
        return data.stream().mapToInt(Integer::intValue).sum();
    }
}
