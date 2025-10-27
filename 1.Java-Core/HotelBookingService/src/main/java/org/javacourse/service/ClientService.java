package org.javacourse.service;

import org.javacourse.model.Bill;
import org.javacourse.model.Client;
import org.javacourse.repository.ClientRepository;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(String firstName, String lastName, String phone, String email, double initialBalance) {
        Bill bill = new Bill(initialBalance);
        Client client = new Client(firstName, lastName, phone, email, bill);
        clientRepository.addClient(client);
        System.out.println("Client " + firstName + " " + lastName + " created with balance " + bill.getBalance() + "$.");
    }

    public Client findClientByPhone(String phone) {
        return clientRepository.getClientByPhone(phone);
    }

    public void addFundsToClient(String phone, double amount) {
        Client client = findClientByPhone(phone);
        if (client != null) {
            client.getBill().deposit(amount);
            System.out.println("Client " + phone + " deposited" + amount + "$");
        }else {
            System.out.println("Client " + phone + " not found");
        }
    }
    
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
    
    public void showAllClients() {
        System.out.println("Clients:");
        for (var client : clientRepository.getAllClients()) {
            System.out.println("- " + client.getFirstName() + " " + 
                             client.getLastName() + " (" + client.getEmail() + 
                             "), balance: " + String.format("%.2f", client.getBill().getBalance()));
        }
    }
}

