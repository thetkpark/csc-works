package csc319.block4.bankaccountjpa.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BankAccount {

    @Id
    private String accountNumber;
    private String name;
    private String branch;
    private double amount;
}
