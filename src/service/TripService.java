package service;

import adapter.*;
import builder.TripBuilder;
import entities.*;
import strategy.*;
import observer.*;

import java.util.Scanner;

public class TripService {

    public void createTrip() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("From: ");
        String from = scanner.nextLine();

        System.out.print("To: ");
        String to = scanner.nextLine();

        System.out.print("Nights: ");
        int nights = scanner.nextInt();

        System.out.println("\nRoute type: 1-Fastest, 2-Beautiful, 3-Safest");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        RoutePlanner planner = new RoutePlanner();
        switch (choice) {
            case 1 -> planner.setStrategy(new FastestRoute());
            case 2 -> planner.setStrategy(new BeautifulRoute());
            case 3 -> planner.setStrategy(new SafestRoute());
            default -> planner.setStrategy(new FastestRoute());
        }

        Route route = planner.buildRoute(from, to);

        try {
            Flight flight = new FlightAdapter().getFlight(from, to);
            Hotel hotel = new HotelAdapter().getHotel(to, nights);

            if (flight == null || hotel == null) {
                System.out.println("Flight or hotel not found");
                return;
            }

            Trip trip = new TripBuilder()
                    .setRoute(route)
                    .setFlight(flight)
                    .setHotel(hotel)
                    .build();

            System.out.println("\n=== TRIP CREATED ===");
            System.out.println(trip);
            System.out.println("Total: $" + (flight.getPrice() + (nights * hotel.getPricePerNight())));

            TripNotifier notifier = new TripNotifier();
            notifier.addObserver(new User("Nuray"));
            notifier.addObserver(new User("Altynay"));
            notifier.addObserver(new User("Zaure"));
            notifier.notifyTripCreated(trip);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}