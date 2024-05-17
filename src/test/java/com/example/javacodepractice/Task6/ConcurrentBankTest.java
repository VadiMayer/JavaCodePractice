package com.example.javacodepractice.Task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
        Thread threadForDepositForFirstStream = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                concurrentBank.getBankAccounts().get(1L).deposit(BigDecimal.valueOf(1));
            }
        });

        Thread threadForWithdrawForFirstStream = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                concurrentBank.getBankAccounts().get(1L).withdraw(BigDecimal.valueOf(1));
            }
        });

        Thread threadForDepositForSecondStream = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                concurrentBank.getBankAccounts().get(2L).deposit(BigDecimal.valueOf(1));
            }
        });

        Thread threadForWithdrawForSecondStream = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                concurrentBank.getBankAccounts().get(2L).withdraw(BigDecimal.valueOf(1));
            }
        });

        Thread threadForTransfer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                concurrentBank.transfer(concurrentBank.getBankAccounts().get(1L), concurrentBank.getBankAccounts().get(2L), BigDecimal.valueOf(1));
            }
        });

        threadForDepositForFirstStream.start();
        threadForWithdrawForFirstStream.start();
        threadForDepositForSecondStream.start();
        threadForWithdrawForSecondStream.start();
        threadForTransfer.start();

        threadForDepositForFirstStream.join();
        threadForWithdrawForFirstStream.join();
        threadForDepositForSecondStream.join();
        threadForWithdrawForSecondStream.join();
        threadForTransfer.join();


        Assertions.assertEquals(0, concurrentBank.getBankAccounts().get(1L).getBalance().intValue());
        Assertions.assertEquals(3000, concurrentBank.getBankAccounts().get(2L).getBalance().intValue());

    }
}