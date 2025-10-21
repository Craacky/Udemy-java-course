package org.javacourse.repository;

import org.javacourse.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clients);
    }

    public Client getClientByPhone(String phone) {
        for (Client client : clients) {
            if (client.getPhoneNumber().equals(phone)) {
                return client;
            }
        }
        return null;
    }
    
    public Client findByEmail(String email) {
        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }
}
