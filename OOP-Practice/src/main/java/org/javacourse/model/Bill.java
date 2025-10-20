package org.javacourse.model;

import jakarta.persistence.*;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Bill() {

    }

    public Long getId() {
        return id;
    }

    private int amount;

    public Bill(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount is negative");
        }
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void deposit(int sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException("Sum should be positive");
        }
        amount += sum;
    }

    public void withdraw(int sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException("Sum should be positive");
        }
        if (amount < sum) {
            throw new IllegalArgumentException("Doesn't have enough money");
        }
        amount -= sum;
    }

    @Override
    public String toString() {
        return "Balance: " + amount + " $";
    }
}
