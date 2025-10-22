package org.javacourse;

import org.javacourse.repository.ClientRepository;
import org.javacourse.repository.HotelRepository;
import org.javacourse.service.BookingService;
import org.javacourse.service.ClientService;
import org.javacourse.service.HotelService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepository();
        HotelRepository hotelRepository = new HotelRepository();

        ClientService clientService = new ClientService(clientRepository);
        HotelService hotelService = new HotelService(hotelRepository);
        BookingService bookingService = new BookingService(hotelRepository, clientService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Hotel Booking System!");

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Create client");
            System.out.println("2. Create hotel with random rooms");
            System.out.println("3. Book a room");
            System.out.println("4. Show all clients");
            System.out.println("5. Show all hotels");
            System.out.println("0. Exit");
            System.out.print("Choose an action: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); 
                    clientService.createClient(firstName, lastName, phone, email, balance);
                    break;

                case 2:
                    System.out.print("Enter hotel name: ");
                    String hotelName = scanner.nextLine();
                    System.out.print("Enter number of rooms to create: ");
                    int numberOfRooms = scanner.nextInt();
                    scanner.nextLine(); 
                    hotelService.createHotel(hotelName, numberOfRooms);
                    break;

                case 3:
                    System.out.print("Enter client email: ");
                    String clientEmail = scanner.nextLine();
                    System.out.print("Enter hotel name: ");
                    String hotelNameToBook = scanner.nextLine();
                    System.out.print("Enter required capacity: ");
                    int requiredCapacity = scanner.nextInt();
                    scanner.nextLine(); 
                    bookingService.bookRoom(clientEmail, hotelNameToBook, requiredCapacity);
                    break;

                case 4:
                    clientService.showAllClients();
                    break;

                case 5:
                    hotelService.showAllHotels();
                    break;

                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }
}