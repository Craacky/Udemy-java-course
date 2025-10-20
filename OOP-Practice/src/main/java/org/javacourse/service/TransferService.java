package org.javacourse.service;

import jakarta.persistence.EntityManager;
import org.javacourse.model.Account;

public record TransferService(EntityManager em) {

    public void transfer(Account from, Account to, int sum) {
        em.getTransaction().begin();
        if (sum < 0) throw new IllegalArgumentException("sum cannot be negative");

        if (from.getBill().getAmount() >= sum) {
            int newAmount = from.getBill().getAmount() - sum;
            from.getBill().setAmount(newAmount);
            int toNewAmount = to.getBill().getAmount() + sum;
            to.getBill().setAmount(toNewAmount);
        } else {
            em.getTransaction().rollback();
            throw new IllegalStateException("Not enough money");
        }
        em.merge(from.getBill());
        em.merge(to.getBill());
        em.getTransaction().commit();
        System.out.println("Transferred [" + sum + " $] | from bill [" + from.getBill() + "] to bill [" + to.getBill() + "]");
    }
}
