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
}
