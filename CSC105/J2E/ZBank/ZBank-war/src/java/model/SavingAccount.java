/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CSC102-105
 */
public class SavingAccount {
    private String AccountNumber;
    private double balance;
    private String customerID;

    public SavingAccount(String AccountNumber, double balance, String customerID) {
        this.AccountNumber = AccountNumber;
        this.balance = balance;
        this.customerID = customerID;
    }
    
     
    

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
}
