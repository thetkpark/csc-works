package csc319.j4.bankaccount.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @AllArgsConstructor
public class BankAccount {
    private String name;
    private String accountId;
    private String branch;
    private double amount;

    public boolean withdraw(double amount) {
        if (this.amount < amount) return false;
        this.amount -= amount;
        return true;
    }

    public boolean deposit(double amount) {
        this.amount += amount;
        return true;
    }
}
