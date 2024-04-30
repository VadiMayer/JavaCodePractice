package com.example.javacodepractice;

import com.example.javacodepractice.model.MyStringBuilder;
import com.example.javacodepractice.model.Repository;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JavaCodePracticeApplication {

	public static void main(String[] args) {

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
