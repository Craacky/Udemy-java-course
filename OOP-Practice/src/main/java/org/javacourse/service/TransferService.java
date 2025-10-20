package org.javacourse.service;

import jakarta.persistence.EntityManager;
import org.javacourse.model.Account;
import org.javacourse.model.Deposit;

public class TransferService {
    private final EntityManager em;

    public TransferService(EntityManager em) {
        this.em = em;
    }

    public void transfer(Account from, Account to, int sum) {
        em.getTransaction().begin();
        if (sum < 0) throw new IllegalArgumentException("sum cannot be negative");
        from.getBill().withdraw(sum);
        to.getBill().deposit(sum);
        em.merge(from.getBill());
        em.merge(to.getBill());
        em.getTransaction().commit();
        System.out.println("Transferred [" + sum + " $] | from bill [" + from.getBill() + "] to bill [" + to.getBill() + "]");
    }
}
