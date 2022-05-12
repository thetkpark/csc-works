package csc319.j4.bankaccount.controller;

import csc319.j4.bankaccount.model.BankAccount;
import csc319.j4.bankaccount.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/bank-account")
public class BankAccountController {
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    };

    @PostMapping
    public @ResponseBody boolean createBankAccount(@RequestBody BankAccount bankAccount) {
        return this.bankAccountRepository.addBankAccount(bankAccount);
    }

    @GetMapping("/{id}")
    public @ResponseBody BankAccount getBankAccount(@PathVariable String id) {
        return this.bankAccountRepository.findById(id);
    }

    @PostMapping("/withdraw/{id}")
    public @ResponseBody boolean withdraw(@PathVariable String id, @RequestParam double amount)  {
        BankAccount account = this.bankAccountRepository.findById(id);
        if (account == null) return false;
        return account.withdraw(amount);
    }

    @PostMapping("/deposit/{id}")
    public @ResponseBody boolean deposit(@PathVariable String id, @RequestParam double amount)  {
        BankAccount account = this.bankAccountRepository.findById(id);
        if (account == null) return false;
        return account.deposit(amount);
    }

    @PostMapping("/transfer/{id}")
    public @ResponseBody boolean deposit(@PathVariable String id, @RequestParam double amount, @RequestParam String toId)  {
        BankAccount accountFrom = this.bankAccountRepository.findById(id);
        BankAccount accountTo = this.bankAccountRepository.findById(toId);
        if (accountFrom == null || accountTo == null) return false;
        if (!accountFrom.withdraw(amount)) return false;
        return accountTo.deposit(amount);
    }
}
