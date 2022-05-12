package csc319.j4.bankaccount.repository;

import csc319.j4.bankaccount.model.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBankAccountRepository implements BankAccountRepository {
    private Set<BankAccount> bankAccount = Collections.newSetFromMap(new ConcurrentHashMap<BankAccount, Boolean>());

    @Override
    public boolean addBankAccount(BankAccount account) {
        if (this.findById(account.getAccountId()) == null) {
            return this.bankAccount.add(account);
        }
        return false;
    }

    @Override
    public BankAccount findById(String accountId) {
        Optional<BankAccount> found = this.bankAccount.stream().filter(a -> a.getAccountId().equalsIgnoreCase(accountId)).findAny();
        return found.orElse(null);
    }
}
