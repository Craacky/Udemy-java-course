package org.javacourse.service;

import jakarta.persistence.EntityManager;
import org.javacourse.model.Bill;
import org.javacourse.model.Deposit;

public class DepositService {
    private final EntityManager em;

    public DepositService(EntityManager em) {
        this.em = em;
    }

    public void deposit(Bill bill, int sum) {
        em.getTransaction().begin();

        bill.deposit(sum);
        em.merge(bill);
        em.persist(new Deposit(bill, sum));

        em.getTransaction().commit();
        System.out.println("Deposit: " + sum + "$ | " + bill);

    }
}
