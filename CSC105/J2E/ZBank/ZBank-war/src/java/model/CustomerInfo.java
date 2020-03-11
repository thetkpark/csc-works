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
public class CustomerInfo {
    private String customerID;
    private String name;
    private String citizenID;
    private String birthdate; // DD-MM-YYYY
    private String address;

    public CustomerInfo(String customerID, String name, String citizenID, String birthdate, String address) {
        this.customerID = customerID;
        this.name = name;
        this.citizenID = citizenID;
        this.birthdate = birthdate;
        this.address = address;
    }
    

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(String citizenID) {
        this.citizenID = citizenID;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    

}
