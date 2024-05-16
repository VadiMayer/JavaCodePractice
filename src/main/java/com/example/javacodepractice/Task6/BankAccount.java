package com.example.javacodepractice.Task6;

import java.math.BigDecimal;

public class BankAccount extends ConcurrentBank {

    private Long id;

    private BigDecimal balance;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal moneyClient) {
        getBankAccounts().get(id).balance = balance.add(moneyClient);
        return balance = balance.add(moneyClient);
    }

    public BigDecimal withdraw(BigDecimal moneyClient) {
        getBankAccounts().get(id).balance = balance.subtract(moneyClient);
        return balance = moneyClient.subtract(moneyClient);
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
