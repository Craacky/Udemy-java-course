package org.javacourse.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Bill bill;
    private int amount;
    private LocalDateTime createdAt;

    public Payment() {
    }

    public Payment(Bill bill, int amount) {
        this.bill = bill;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
    }
}
