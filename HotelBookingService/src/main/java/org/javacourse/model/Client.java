package org.javacourse.model;


public class Client {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Bill bill;

    public Bill getBill() {
        return bill;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public Client(String firstName, String lastName, String phoneNumber, String email, Bill bill) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bill = bill;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
