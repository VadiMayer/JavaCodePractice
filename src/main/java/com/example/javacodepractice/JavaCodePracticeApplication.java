package com.example.javacodepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@SpringBootApplication
public class JavaCodePracticeApplication {

	volatile static boolean x = true;

	public static void main(String[] args) throws InterruptedException {
//		SpringApplication.run(JavaCodePracticeApplication.class, args);
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				x = true;
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				x = false;
			}
		});

		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(x);
	}

}
