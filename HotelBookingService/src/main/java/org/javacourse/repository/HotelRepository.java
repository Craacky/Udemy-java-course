package org.javacourse.repository;

import org.javacourse.model.Hotel;
import org.javacourse.model.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelRepository {
    private List<Hotel> hotels = new ArrayList<>();

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public List<Hotel> getAllHotels() {
        return new ArrayList<>(hotels);
    }

    public Hotel findByName(String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(hotelName)) {
                return hotel;
            }
        }
        return null;
    }
    
    public Room findAvailableRoomByCapacity(Hotel hotel, int requiredCapacity) {
        for (Room room : hotel.getRooms()) {
            if (room.isAvailable() && room.getCapacity() >= requiredCapacity) {
                return room;
            }
        }
        return null;
    }
}
