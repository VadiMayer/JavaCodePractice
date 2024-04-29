package com.example.javacodepractice;

import com.example.javacodepractice.model.MyStringBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class JavaCodePracticeApplication {

	public static void main(String[] args) {

		MyStringBuilder myStringBuilder = new MyStringBuilder();

		myStringBuilder.append("1");

		myStringBuilder.append("3");

		System.out.println(myStringBuilder);



//		SpringApplication.run(JavaCodePracticeApplication.class, args);
	}

}
