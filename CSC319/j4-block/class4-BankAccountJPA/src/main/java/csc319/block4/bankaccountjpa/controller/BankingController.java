package csc319.block4.bankaccountjpa.controller;

import csc319.block4.bankaccountjpa.repository.BankAccount;
import csc319.block4.bankaccountjpa.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounting")
public class BankingController {
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankingController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @PostMapping("/createAccount")
    public boolean addAccount(@RequestBody BankAccount account) {
        this.bankAccountRepository.save(account);
        return true;
    }

    @GetMapping("/searchAccount")
    public BankAccount getAccountsByNumber(@RequestParam String accountNumber) {
        return this.bankAccountRepository.findById(accountNumber).orElse(null);
    }

    @GetMapping("/listAllAccount")
    public Collection<BankAccount> listAllAccounts() {
        return this.bankAccountRepository.findAll();
    }

    @PostMapping("/updateAccount")
    public BankAccount updateAccount(@RequestParam String accountNumber, @RequestParam double newAmount) {
        Optional<BankAccount> queriedAccount = this.bankAccountRepository.findById(accountNumber);
        if (queriedAccount.isEmpty()) return null;

        BankAccount account = queriedAccount.get();
        account.setAmount(newAmount);
        return this.bankAccountRepository.save(account);
    }

    @PostMapping("/transfer")
    public boolean transferMoney(@RequestParam String accountNumber, @RequestParam String toAccountNumber, @RequestParam double amount) {
        Optional<BankAccount> fromAccountOptional = this.bankAccountRepository.findById(accountNumber);
        Optional<BankAccount> toAccountOptional = this.bankAccountRepository.findById(toAccountNumber);
        if (fromAccountOptional.isEmpty() || toAccountOptional.isEmpty()) return false;

        BankAccount fromAccount = fromAccountOptional.get();
        BankAccount toAccount = toAccountOptional.get();
        if (fromAccount.getAmount() < amount) return false;

        fromAccount.setAmount(fromAccount.getAmount() - amount);
        toAccount.setAmount(toAccount.getAmount() + amount);
        this.bankAccountRepository.saveAll(List.of(fromAccount, toAccount));
        return true;
    }
}
