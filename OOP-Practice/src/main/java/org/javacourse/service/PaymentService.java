package org.javacourse.service;

import jakarta.persistence.EntityManager;
import org.javacourse.model.Bill;
import org.javacourse.model.Payment;

public record PaymentService(EntityManager em) {

    public void pay(Bill bill, int sum) {
        em.getTransaction().begin();

        int newAmount = bill.getAmount() - sum;
        bill.setAmount(newAmount);
        em.merge(bill);
        em.persist(new Payment(bill, sum));

        em.getTransaction().commit();
        System.out.println("Payment: " + sum + "$ | bill: " + bill.getAmount());

    }
}
