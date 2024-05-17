package com.example.javacodepractice.Task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
    void withdraw() {
        BigDecimal balance = bankAccount.withdraw(BigDecimal.valueOf(1000000));
        Assertions.assertEquals(BigDecimal.valueOf(0), balance);
    }

    @Test
    void getBalance() {
        Assertions.assertEquals(1000000, bankAccount.getBalance().intValue());
    }
}