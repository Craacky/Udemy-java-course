package org.javacourse.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Bill bill;

    private int amount;
    private LocalDateTime createdAt;

    public Deposit() {}
    public Deposit(Bill bill, int amount) {
        this.bill = bill;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
    }
}
