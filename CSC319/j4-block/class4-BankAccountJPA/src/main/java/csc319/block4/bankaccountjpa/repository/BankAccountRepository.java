package csc319.block4.bankaccountjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, String> {
    Collection<BankAccount> findAll();
}
