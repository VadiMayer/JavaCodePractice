package com.example.javacodepractice.Task1;

public class Snapshot {
    private final byte[] value;

    private final int count;

    public Snapshot(byte[] value, int count) {
        this.value = value;
        this.count = count;
    }

    public byte[] getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }
}
