package com.example.javacodepractice.model;

public class MyStringBuilder {

    private byte[] value;

    private int count = 0;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    {
        value = new byte[DEFAULT_INITIAL_CAPACITY];
    }

    public void append(String str) {
        if (str == null) {
            System.out.println("Дай не null значение");
        }
        for (int i = count; i <= count; i++) {
            byte[] temp = str.getBytes();
            if ((float) value.length * DEFAULT_LOAD_FACTOR == count) {
                increasingSize();
            }
            System.arraycopy(temp, 0, value, count, temp.length);
        }
        count++;
    }

    private void increasingSize() {
        byte[] stringsNewArray = new byte[value.length + count];
        System.arraycopy(value, 0, stringsNewArray, 0, count);
        value = stringsNewArray;
    }

    public Snapshot createSnapshot() {
        byte[] bytes = new byte[value.length];
        System.arraycopy(value, 0, bytes, 0, count);
        return new Snapshot(bytes, count);
    }

    public void undo(Snapshot snapshot) {
        this.value = snapshot.getValue();
        this.count = snapshot.getCount();
    }

    @Override
    public String toString() {
        return new String(value);
    }
}
