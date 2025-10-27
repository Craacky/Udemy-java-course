package org.javacourse.service;

import org.javacourse.model.Client;
import org.javacourse.model.Hotel;
import org.javacourse.model.Room;
import org.javacourse.repository.HotelRepository;

public class BookingService {
    private HotelRepository hotelRepository;
    private ClientService clientService;

    public BookingService(HotelRepository hotelRepository, ClientService clientService) {
        this.hotelRepository = hotelRepository;
        this.clientService = clientService;
    }

    public boolean bookRoom(String clientEmail, String hotelName, int requiredCapacity) {
        Client client = clientService.findByEmail(clientEmail);
        Hotel hotel = hotelRepository.findByName(hotelName);

        if (client == null || hotel == null) {
            System.out.println("Client or hotel not found");
            return false;
        }

        Room availableRoom = hotelRepository.findAvailableRoomByCapacity(hotel, requiredCapacity);
        if (availableRoom == null) {
            System.out.println("No available rooms for " + requiredCapacity + " person(s) in hotel " + hotelName);
            return false;
        }

        if (client.getBill().getBalance() < availableRoom.getPrice()) {
            System.out.println("Client doesn't have enough funds to book room costing " + String.format("%.2f", availableRoom.getPrice()));
            return false;
        }

        availableRoom.setAvailable(false);
        client.getBill().withdraw(availableRoom.getPrice());

        System.out.println("Room booked successfully for client " + client.getFirstName() + 
                          ". Deducted " + String.format("%.2f", availableRoom.getPrice()) + 
                          ", remaining balance: " + String.format("%.2f", client.getBill().getBalance()));
        return true;
    }
}
