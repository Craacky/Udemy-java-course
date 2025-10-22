package org.javacourse.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    String hotelName;
    private List<Room> rooms = new ArrayList<Room>();

    public Hotel(String hotelName, List<Room> rooms) {
        this.hotelName = hotelName;
        this.rooms = rooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
