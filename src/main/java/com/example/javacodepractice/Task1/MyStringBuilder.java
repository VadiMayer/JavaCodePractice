package com.example.javacodepractice.Task1;

public class MyStringBuilder {
    Repository repository;

    private byte[] value;

    private int count = 0;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    {
        value = new byte[DEFAULT_INITIAL_CAPACITY];
        repository = new Repository();
    }

    public void append(String str) {
        if (str == null) {
            System.out.println("Дай не null значение");
        }
        int countChar = 0;
        for (int i = count; i <= count; i++) {
            byte[] temp = str.getBytes();
            countChar = temp.length;
            if ((float) value.length * DEFAULT_LOAD_FACTOR == count || value.length * DEFAULT_LOAD_FACTOR > count) {
                increasingSize();
            }
            try {
                System.arraycopy(temp, 0, value, count, temp.length);
            } catch (ArrayIndexOutOfBoundsException e) {
                increasingSizeIfLongString(countChar);
                System.arraycopy(temp, 0, value, count, temp.length);
            }
        }
        if (countChar > 1) {
            count = count + countChar;
            return;
        }
        count++;
    }

    private void increasingSize() {
        byte[] stringsNewArray = new byte[value.length + count];
        System.arraycopy(value, 0, stringsNewArray, 0, count);
        value = stringsNewArray;
    }

    private void increasingSizeIfLongString(int numberOfCharacters) {
        byte[] stringsNewArray = new byte[value.length + numberOfCharacters];
        System.arraycopy(value, 0, stringsNewArray, 0, value.length);
        value = stringsNewArray;
    }

    public void createSnapshot() {
        byte[] bytes = new byte[value.length];
        System.arraycopy(value, 0, bytes, 0, count);
        repository.setSnapshot(new Snapshot(bytes, count));
    }

    public void undo() {
        this.value = repository.getSnapshot().getValue();
        this.count = repository.getSnapshot().getCount();
    }

    @Override
    public String toString() {
        return new String(value);
    }
}
