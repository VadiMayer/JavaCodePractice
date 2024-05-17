package com.example.javacodepractice.Task6;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class BankAccount {

    private Long id;

    private final AtomicReference<BigDecimal> balance;

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public BankAccount(BigDecimal balance) {
        this.balance = new AtomicReference<>(BigDecimal.ZERO);
        this.balance.set(balance);
    }

    public BigDecimal deposit(BigDecimal moneyClient) {
        synchronized (lock1) {
            this.balance.getAndUpdate(bigDecimal -> bigDecimal.add(moneyClient));
            return balance.get();
        }
    }

    public BigDecimal withdraw(BigDecimal moneyClient) {
        synchronized (lock2) {
            this.balance.getAndUpdate(bigDecimal -> bigDecimal.subtract(moneyClient));
            return balance.get();
        }
    }

    public BigDecimal getBalance() {
        return balance.get();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
