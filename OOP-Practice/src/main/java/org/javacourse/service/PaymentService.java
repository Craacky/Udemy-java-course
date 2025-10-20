package org.javacourse.service;

import jakarta.persistence.EntityManager;
import org.javacourse.model.Bill;
import org.javacourse.model.Payment;

public class PaymentService {
    private final EntityManager em;

    public PaymentService(EntityManager em) {
        this.em = em;
    }

    public void pay(Bill bill, int sum) {
        em.getTransaction().begin();

        bill.withdraw(sum);
        em.merge(bill);
        em.persist(new Payment(bill, sum));

        em.getTransaction().commit();
        System.out.println("Payment: " + sum + "$ | bill: " + bill.getAmount());

    }
}
