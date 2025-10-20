package org.javacourse.service;

import jakarta.persistence.EntityManager;
import org.javacourse.model.Bill;
import org.javacourse.model.Deposit;

public record DepositService(EntityManager em) {

    public void makeDeposit(Bill bill, int sum) {
        em.getTransaction().begin();

        int newAmount = bill.getAmount() + sum;
        bill.setAmount(newAmount);
        em.merge(bill);
        em.persist(new Deposit(bill, sum));

        em.getTransaction().commit();
        System.out.println("Deposit: " + sum + "$ | " + bill);

    }
}
