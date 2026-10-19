// MENDOZA

package com.mycompany.fmp2;

public class Account {
    private final int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Error: Amount must be positive.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Error: Amount must be positive.");
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException("Error: Insufficient funds.");
        }
        this.balance -= amount;
    }
}