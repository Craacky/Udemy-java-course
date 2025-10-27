package org.javacourse.service;

import org.javacourse.model.Hotel;
import org.javacourse.model.Room;
import org.javacourse.repository.HotelRepository;

import java.util.ArrayList;
import java.util.Random;

public class HotelService {
    private HotelRepository hotelRepository;
    private Random random;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
        this.random = new Random();
    }

    public void createHotel(String name, int numberOfRooms) {
        ArrayList<Room> rooms = new ArrayList<>();
        
        for (int i = 0; i < numberOfRooms; i++) {
            int capacity = random.nextInt(4) + 1;
            double price = 50 + random.nextDouble() * 150;
            Room room = new Room(capacity, price, true);
            rooms.add(room);
        }
        
        Hotel hotel = new Hotel(name, rooms);
        hotelRepository.addHotel(hotel);
        System.out.println("Hotel " + name + " created with " + numberOfRooms + " rooms");
    }
    
    public Hotel findByName(String name) {
        return hotelRepository.findByName(name);
    }
    
    public void showAllHotels() {
        System.out.println("Hotels:");
        for (var hotel : hotelRepository.getAllHotels()) {
            System.out.println("- " + hotel.getHotelName() + 
                             ", rooms: " + hotel.getRooms().size());
            for (var room : hotel.getRooms()) {
                System.out.println("  * Capacity: " + room.getCapacity() + 
                                 ", Price: " + String.format("%.2f", room.getPrice()) + 
                                 ", Available: " + room.isAvailable());
            }
        }
    }
}
