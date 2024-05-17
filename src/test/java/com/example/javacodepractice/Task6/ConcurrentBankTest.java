package com.example.javacodepractice.Task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

class ConcurrentBankTest {

    ConcurrentBank concurrentBank;

    @BeforeEach
    void setUp() {
        concurrentBank = new ConcurrentBank();
        for (int i = 0; i < 100; i++) {
            concurrentBank.createAccount(BigDecimal.valueOf(1000 + (i * 1000)));
        }
    }

    @Test
    void createAccount() {
        Assertions.assertEquals(100, concurrentBank.getBankAccounts().size());
        ConcurrentBank.setID(1L);
    }

    @Test
    void transfer() {
        concurrentBank.transfer(concurrentBank.getBankAccounts().get(1L), concurrentBank.getBankAccounts().get(2L), BigDecimal.valueOf(100));
        Assertions.assertEquals(2100, concurrentBank.getBankAccounts().get(2L).getBalance().intValue());
        Assertions.assertEquals(900, concurrentBank.getBankAccounts().get(1L).getBalance().intValue());
    }

    @Test
    void getTotalBalance() {
        Assertions.assertEquals(5050000, concurrentBank.getTotalBalance().intValue());
    }

    @Test
    void transferInConcurrent() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(15);
        List<Callable<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            tasks.add(() -> {
                for (int j = 0; j < 100000; j++) {
                    concurrentBank.transfer(concurrentBank.getBankAccounts().get(16L), concurrentBank.getBankAccounts().get(2L), BigDecimal.valueOf(1));
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

        Assertions.assertEquals(0, concurrentBank.getBankAccounts().get(16L).getBalance().intValue());
        Assertions.assertEquals(18000, concurrentBank.getBankAccounts().get(2L).getBalance().intValue());

    }
}