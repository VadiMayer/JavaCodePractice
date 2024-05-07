package com.example.javacodepractice.Task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyStringBuilderTest {
    MyStringBuilder myStringBuilder;

    @BeforeEach
    void createStringBuilder() {
        myStringBuilder = new MyStringBuilder(new Repository());
    }

    @Test
    void appendLongString() {
        for (int i = 1; i < 1000000000; i = i * 100) {
            myStringBuilder.append(i + "hfghdjghjfghjfghjgfjfghjfgjhfghjddsfgjdghjdhj");
        }
    }

    @Test
    void append100Numbers() {
        for (int i = 1; i < 100; i++) {
            myStringBuilder.append(String.valueOf(i));
        }
    }

    @Test
    void createSnapshot() {
        myStringBuilder.append("1");
        myStringBuilder.append("2");
        myStringBuilder.append("3");
        myStringBuilder.createSnapshot();
        myStringBuilder.append("3");
        myStringBuilder.append("4");
    }

    @Test
    void undo() {
        myStringBuilder.append("1");
        myStringBuilder.append("2");
        myStringBuilder.append("3");
        System.out.println(myStringBuilder);
        myStringBuilder.createSnapshot();
        myStringBuilder.append("3");
        myStringBuilder.append("4");
        myStringBuilder.undo();
        System.out.println(myStringBuilder);
    }
}