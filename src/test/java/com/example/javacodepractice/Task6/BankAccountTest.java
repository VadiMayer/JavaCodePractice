package com.example.javacodepractice.Task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(BigDecimal.valueOf(1000000));
    }

    @Test
    void deposit1000000() {
        BigDecimal balance = bankAccount.deposit(BigDecimal.valueOf(1000000));
        Assertions.assertEquals(BigDecimal.valueOf(2000000), balance);
    }

    @Test
    void withdraw1000000() {
        BigDecimal balance = bankAccount.withdraw(BigDecimal.valueOf(1000000));
        Assertions.assertEquals(BigDecimal.valueOf(0), balance);
    }

    @Test
    void getBalance() {
        Assertions.assertEquals(1000000, bankAccount.getBalance().intValue());
    }

    @Test
    void depositInConcurrent() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        List<Callable<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            tasks.add(() -> {
                for (int j = 0; j < 100000; j++) {
                    bankAccount.deposit(BigDecimal.valueOf(1));
                }
                return null;
            });
        }

        List<Future<Void>> futures = executorService.invokeAll(tasks);

        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Assertions.assertEquals(2500000, bankAccount.getBalance().intValue());
    }

    @Test
    void withdrawInConcurrent() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        List<Callable<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            tasks.add(() -> {
                for (int j = 0; j < 100000; j++) {
                    bankAccount.withdraw(BigDecimal.valueOf(1));
                }
                return null;
            });
        }

        List<Future<Void>> futures = executorService.invokeAll(tasks);

        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        Assertions.assertEquals(-500000, bankAccount.getBalance().intValue());
    }

}