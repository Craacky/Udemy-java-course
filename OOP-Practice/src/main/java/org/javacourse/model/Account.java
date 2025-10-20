package org.javacourse.model;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;
    @ManyToOne(cascade = CascadeType.ALL)
    private Bill bill;

    public Account(Person person, Bill bill) {
        this.person = person;
        this.bill = bill;
    }

    public Account() {

    }

    public Long getId() {
        return id;
    }
    public Person getPerson() {
        return this.person;
    }
    public Bill getBill() {
        return this.bill;
    }

    @Override
    public String toString() {
        return "Account [person=" + this.person + "| bill=" + this.bill + "$]";
    }
}
