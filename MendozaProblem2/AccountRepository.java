// MENDOZA

package com.mycompany.fmp2;

public class AccountRepository {
    private final Account[] accounts;

    public AccountRepository(Account[] accounts) {
        this.accounts = accounts;
    }

    public Account findAccount(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }
}