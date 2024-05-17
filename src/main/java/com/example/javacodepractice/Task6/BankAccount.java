package com.example.javacodepractice.Task6;

import java.math.BigDecimal;

public class BankAccount {

    private Long id;

    private BigDecimal balance;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal moneyClient) {
        return balance = balance.add(moneyClient);
    }

    public BigDecimal withdraw(BigDecimal moneyClient) {
        return balance = balance.subtract(moneyClient);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
