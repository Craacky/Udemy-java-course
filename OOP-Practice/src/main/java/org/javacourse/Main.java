package org.javacourse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.javacourse.model.*;
import org.javacourse.service.DepositService;
import org.javacourse.service.PaymentService;
import org.javacourse.service.TransferService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bankUP");
        EntityManager em = emf.createEntityManager();

        DepositService depositService = new DepositService(em);
        TransferService transferService = new TransferService(em);
        PaymentService paymentService = new PaymentService(em);

        System.out.println("++++++++++ BANK UP ++++++++++");

        boolean running = true;

        while (running) {
            System.out.println("\nChoose option:");
            System.out.println("1. Create Account");
            System.out.println("2. Show Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Pay");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");
            System.out.print("→ ");

            String choice = SCANNER.nextLine();

            switch (choice) {
                case "1" -> createAccount(em);
                case "2" -> showAccounts(em);
                case "3" -> makeDeposit(em, depositService);
                case "4" -> makePayment(em, paymentService);
                case "5" -> makeTransfer(em, transferService);
                case "6" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        em.close();
        emf.close();
    }

    private static void createAccount(EntityManager em) {
        System.out.print("[First Name] = ");
        String firstName = SCANNER.nextLine();

        System.out.print("[Last Name] = ");
        String lastName = SCANNER.nextLine();

        System.out.print("[Phone Number] = ");
        String phoneNumber = SCANNER.nextLine();

        int startAmount = readInt("[Start Amount] = ");

        Person person = new Person(firstName, lastName, phoneNumber);
        Account account = new Account(person, new Bill(startAmount));

        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();

        System.out.println("✅ Account created successfully.");
    }

    private static void showAccounts(EntityManager em) {
        List<Account> accounts = em.createQuery("SELECT a FROM Account a", Account.class).getResultList();

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("List of accounts:");
        for (Account a : accounts) {
            System.out.printf("ID: %d | %s %s | Phone: %s | Balance: %d%n",
                    a.getId(),
                    a.getPerson().getFirstName(),
                    a.getPerson().getLastName(),
                    a.getPerson().getPhoneNumber(),
                    a.getBill().getAmount());
        }
    }

    private static void makeDeposit(EntityManager em, DepositService depositService) {
        Account account = findAccount(em, "Enter account ID for deposit: ");
        if (account == null) return;

        int amount = readInt("Enter deposit amount = ");
        depositService.deposit(account.getBill(), amount);
    }

    private static void makePayment(EntityManager em, PaymentService paymentService) {
        Account account = findAccount(em, "Enter account ID for payment: ");
        if (account == null) return;

        int amount = readInt("Enter payment amount = ");
        paymentService.pay(account.getBill(), amount);
    }

    private static void makeTransfer(EntityManager em, TransferService transferService) {
        Account from = findAccount(em, "Enter account-sender ID for transfer: ");
        if (from == null) return;

        Account to = findAccount(em, "Enter account-receiver ID for transfer: ");
        if (to == null) return;

        int amount = readInt("Enter transfer amount = ");
        transferService.transfer(from, to, amount);
    }

    private static Account findAccount(EntityManager em, String prompt) {
        System.out.print(prompt);
        try {
            int id = Integer.parseInt(SCANNER.nextLine());
            Account account = em.find(Account.class, id);
            if (account == null) {
                System.out.println("Account with ID " + id + " not found.");
            }
            return account;
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a number.");
            return null;
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }
}
