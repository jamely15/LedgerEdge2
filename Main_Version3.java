package com.djouvens.bank;

import java.util.Scanner;

/**
 * Entry point for the LedgerEdge application.
 * For educational purposes only.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter owner name for new account: ");
        String ownerName = scanner.nextLine().trim();
        if (ownerName.isEmpty()) ownerName = "Unknown";
        Account account = new Account(ownerName);

        System.out.println("Welcome to LedgerEdge!");
        while (true) {
            System.out.printf("Account #%d (%s) | Balance: $%.2f%n",
                              account.getAccountId(),
                              account.getOwnerName(),
                              account.getBalance());
            System.out.println("Select an option: (1) Deposit  (2) Withdraw  (3) Change Owner  (4) Deactivate  (5) Reactivate  (6) Exit");
            System.out.print("> ");

            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Enter deposit amount: ");
                        double amt = Double.parseDouble(scanner.nextLine());
                        account.deposit(amt);
                    }
                    case "2" -> {
                        System.out.print("Enter withdrawal amount: ");
                        double amt = Double.parseDouble(scanner.nextLine());
                        account.withdraw(amt);
                    }
                    case "3" -> {
                        System.out.print("Enter new owner name: ");
                        String newOwner = scanner.nextLine().trim();
                        account.setOwnerName(newOwner);
                    }
                    case "4" -> {
                        account.closeAccount();
                        System.out.println("Account deactivated.");
                    }
                    case "5" -> {
                        account.openAccount();
                        System.out.println("Account reactivated.");
                    }
                    case "6" -> {
                        System.out.println("Thank you for using LedgerEdge. Goodbye!");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid selection—please enter a number from 1 to 6.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.err.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }
}