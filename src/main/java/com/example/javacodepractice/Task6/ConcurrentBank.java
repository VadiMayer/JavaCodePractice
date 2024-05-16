package com.example.javacodepractice.Task6;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentBank {
    private static Long ID = 1L;
    private Map<Long, BankAccount> bankAccounts = new ConcurrentHashMap<>();
    public BankAccount createAccount(BigDecimal invoiceAmount) {
        BankAccount newBankAccount = new BankAccount(invoiceAmount);
        newBankAccount.setId(ID);
        bankAccounts.put(ID++, newBankAccount);
        return newBankAccount;
    }

    public boolean transfer(BankAccount accountSource, BankAccount accountRecipient, BigDecimal amountTransfer) {

        if (bankAccounts.get(accountSource.getId()).getBalance().intValue() < amountTransfer.intValue()) {
            return false;
        } else {
            bankAccounts.get(accountRecipient.getId()).deposit(accountSource.withdraw(amountTransfer));
            return true;
        }
    }

    public BigDecimal getTotalBalance() {
        BigDecimal totalBalance = new BigDecimal(0);
        for (Map.Entry<Long, BankAccount> entry: bankAccounts.entrySet()) {
            totalBalance = totalBalance.add(entry.getValue().getBalance());
        }
        return totalBalance;
    }

    public Map<Long, BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
