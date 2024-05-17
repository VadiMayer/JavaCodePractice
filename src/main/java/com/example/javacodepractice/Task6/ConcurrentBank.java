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
        BankAccount accountSourceFromBankAccounts = bankAccounts.get(accountSource.getId());
        BankAccount accountRecipientFromBankAccounts = bankAccounts.get(accountRecipient.getId());
        if (accountSourceFromBankAccounts.getBalance().intValue() < amountTransfer.intValue()) {
            return false;
        } else {
            accountSourceFromBankAccounts.withdraw(amountTransfer);
            accountRecipientFromBankAccounts.deposit(amountTransfer);
            return true;
        }
    }

    public BigDecimal getTotalBalance() {
        BigDecimal totalBalance = new BigDecimal(0);
        for (Map.Entry<Long, BankAccount> entry : bankAccounts.entrySet()) {
            totalBalance = totalBalance.add(entry.getValue().getBalance());
        }
        return totalBalance;
    }

    public Map<Long, BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public static void setID(Long ID) {
        ConcurrentBank.ID = ID;
    }
}
