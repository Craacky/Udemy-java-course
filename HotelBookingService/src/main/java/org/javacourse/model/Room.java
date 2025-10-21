package org.javacourse.model;

public class Room {
    private int capacity;
    private double price;
    private boolean isAvailable;

    public Room(int capacity, double price, boolean isAvailable) {
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
