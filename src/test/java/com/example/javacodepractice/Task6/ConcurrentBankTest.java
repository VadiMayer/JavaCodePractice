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
    }

    @Test
    void transfer() {
        concurrentBank.transfer(concurrentBank.getBankAccounts().get(1L), concurrentBank.getBankAccounts().get(2L), BigDecimal.valueOf(100));
        Assertions.assertEquals(2100, concurrentBank.getBankAccounts().get(1L).getBalance().intValue());
    }

    @Test
    void getTotalBalance() {

    }
}