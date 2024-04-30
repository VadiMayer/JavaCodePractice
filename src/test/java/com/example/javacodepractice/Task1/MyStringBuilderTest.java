package com.example.javacodepractice.Task1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class MyStringBuilderTest {

    @Test
    void appendLongString() {
        MyStringBuilder myStringBuilder = new MyStringBuilder();
        for (int i = 1; i < 1000000000; i = i * 100) {
            myStringBuilder.append(i + "hfghdjghjfghjfghjgfjfghjfgjhfghjddsfgjdghjdhj");
        }
    }

    @Test
    void append100Numbers() {
        MyStringBuilder myStringBuilder = new MyStringBuilder();
        for (int i = 1; i < 100; i++) {
            myStringBuilder.append(String.valueOf(i));
        }
    }

    @Test
    void createSnapshot() {
    }

    @Test
    void undo() {
    }
}