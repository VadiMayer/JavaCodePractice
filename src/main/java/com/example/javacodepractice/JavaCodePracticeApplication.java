package com.example.javacodepractice;

import com.example.javacodepractice.Task1.MyStringBuilder;
import com.example.javacodepractice.Task1.Repository;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JavaCodePracticeApplication {

	public static void main(String[] args) {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(11);
		stringBuilder.append(22);

		MyStringBuilder myStringBuilder = new MyStringBuilder();

		myStringBuilder.append("1");

		myStringBuilder.append("3");
		myStringBuilder.append("3");
		myStringBuilder.append("3");

		Repository repository = new Repository();

		repository.setSnapshot(myStringBuilder.createSnapshot());

		myStringBuilder.append("3");
		myStringBuilder.append("3");
		myStringBuilder.append("3");
		myStringBuilder.append("3");
		myStringBuilder.append("3");
		myStringBuilder.append("3");

		System.out.println("Вносим изменения");

		System.out.println(myStringBuilder);

		myStringBuilder.undo(repository.getSnapshot());

		System.out.println("Отменяем изменения");

		System.out.println(myStringBuilder);

//		SpringApplication.run(JavaCodePracticeApplication.class, args);
	}

}
