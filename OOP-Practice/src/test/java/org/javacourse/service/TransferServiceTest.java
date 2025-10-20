package org.javacourse.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.javacourse.model.Account;
import org.javacourse.model.Bill;
import org.javacourse.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransferServiceTest {

    @Mock
    private EntityManager em;

    @Mock
    private EntityTransaction transaction;

    @InjectMocks
    private TransferService transferService;

    private Account from;
    private Account to;

    @BeforeEach
    void setUp() {
        Person person1 = new Person("John", "Doe", "1234567890");
        Bill bill1 = new Bill(1000);
        from = new Account(person1, bill1);

        Person person2 = new Person("Jane", "Doe", "0987654321");
        Bill bill2 = new Bill(500);
        to = new Account(person2, bill2);
    }

    @Test
    void transfer_shouldSucceed_whenEnoughMoney() {
        when(em.getTransaction()).thenReturn(transaction);

        transferService.transfer(from, to, 500);

        assertEquals(500, from.getBill().getAmount());
        assertEquals(1000, to.getBill().getAmount());
    }

    @Test
    void transfer_shouldThrowException_whenNotEnoughMoney() {
        when(em.getTransaction()).thenReturn(transaction);

        assertThrows(IllegalStateException.class, () -> {
            transferService.transfer(from, to, 1500);
        });

        assertEquals(1000, from.getBill().getAmount());
        assertEquals(500, to.getBill().getAmount());
    }
}
