package csc319.j4.bankaccount.repository;

import csc319.j4.bankaccount.model.BankAccount;

import java.util.HashSet;
import java.util.Set;

public interface BankAccountRepository {
    public boolean addBankAccount(BankAccount account);
    public BankAccount findById(String accountId);
}
