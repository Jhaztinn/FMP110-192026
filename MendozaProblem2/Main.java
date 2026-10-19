// MENDOZA

package com.mycompany.fmp2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account[] initialAccounts = new Account[] {
            new Account(101, 1000.00),
            new Account(102, 500.00)
        };

        AccountRepository repo = new AccountRepository(initialAccounts);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1 Balance | 2 Deposit | 3 Withdraw | 0 Exit");
            System.out.print("Select an option: ");

            try {
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    continue;
                }

                if (choice < 1 || choice > 3) {
                    System.out.println("Error: Invalid option. Please select 0-3.");
                    continue;
                }

                System.out.print("Enter Account Number: ");
                int accNum = scanner.nextInt();

                Account acc = repo.findAccount(accNum);
                if (acc == null) {
                    System.out.println("Error: Account not found.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.printf("Current Balance for Account %d: %.2f\n", 
                                          acc.getAccountNumber(), acc.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter Deposit Amount: ");
                        double depAmount = scanner.nextDouble();
                        acc.deposit(depAmount);
                        System.out.printf("Deposit Successful. New Balance: %.2f\n", acc.getBalance());
                        break;

                    case 3:
                        System.out.print("Enter Withdrawal Amount: ");
                        double drawAmount = scanner.nextDouble();
                        acc.withdraw(drawAmount);
                        System.out.printf("Withdrawal Successful. New Balance: %.2f\n", acc.getBalance());
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Enter a valid number.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
