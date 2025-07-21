package com.djouvens.bank;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Represents an advanced bank account with deposit, withdrawal, and transfer functionality,
 * including unique account identifiers and minimum balance enforcement.
 * For educational purposes only.
 */
public class Account {
    private static final AtomicLong NEXT_ID = new AtomicLong(1);
    private static final double MIN_BALANCE = 0.0;

    private final long accountId;
    private double balance;
    private String ownerName;
    private boolean active;

    /**
     * Creates a new Account with zero initial balance and specified owner.
     * @param ownerName The name of the account owner.
     */
    public Account(String ownerName) {
        this.accountId = NEXT_ID.getAndIncrement();
        this.balance = 0.0;
        this.ownerName = ownerName != null ? ownerName : "Unknown";
        this.active = true;
    }

    /**
     * Returns the unique account identifier.
     * @return account ID
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Returns the current balance.
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the account owner's name.
     * @return owner name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Sets the account owner's name.
     * @param ownerName New owner name.
     */
    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }
        this.ownerName = ownerName;
    }

    /**
     * Checks if the account is active.
     * @return true if active, false otherwise
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Deposits the specified amount into the account.
     * @param amount positive amount to deposit
     * @throws IllegalArgumentException if amount is negative or zero
     * @throws IllegalStateException if account is not active
     */
    public void deposit(double amount) {
        checkActive();
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    /**
     * Withdraws the specified amount from the account if sufficient funds exist.
     * @param amount positive amount to withdraw
     * @throws IllegalArgumentException if amount is negative or zero
     * @throws IllegalStateException    if insufficient funds or account is not active
     */
    public void withdraw(double amount) {
        checkActive();
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (balance - amount < MIN_BALANCE) {
            throw new IllegalStateException(
                "Insufficient funds: requested " + amount + ", available " + balance
            );
        }
        balance -= amount;
    }

    /**
     * Transfers the specified amount to another account.
     * @param target Target Account to transfer to.
     * @param amount Amount to transfer.
     * @throws IllegalArgumentException if target is null or amount is invalid.
     * @throws IllegalStateException if insufficient funds or account is not active.
     */
    public void transferTo(Account target, double amount) {
        checkActive();
        if (target == null) {
            throw new IllegalArgumentException("Target account cannot be null");
        }
        this.withdraw(amount);
        target.deposit(amount);
    }

    /**
     * Deactivates the account.
     */
    public void closeAccount() {
        active = false;
    }

    /**
     * Reactivates the account.
     */
    public void openAccount() {
        active = true;
    }

    private void checkActive() {
        if (!active) {
            throw new IllegalStateException("Account is not active");
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Account[ID=%d, Owner=%s, Balance=%.2f, Active=%b]",
            accountId, ownerName, balance, active
        );
    }
}