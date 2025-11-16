package service;

import adapter.*;
import builder.TripBuilder;
import entities.*;
import entities.transport.*;
import strategy.*;
import observer.*;
import decorator.*;


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

        System.out.println("Transport type: 1-Plane, 2-Train, 3-Car, 4-Bus");
        System.out.print("Your choice: ");
        int transportChoice = scanner.nextInt();

        Transport transport;
        switch (transportChoice) {
            case 1 -> transport = new Plane();
            case 2 -> transport = new Train();
            case 3 -> transport = new Car();
            case 4 -> transport = new Bus();
            default -> transport = new Plane();
        }
        route.setTransport(transport);

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

            TripComponent finalTrip = trip;

            System.out.println("\nExtra services:");
            System.out.print("Add breakfast? 1-Yes, 0-No: ");
            int addBreakfast = scanner.nextInt();

            System.out.print("Add insurance? 1-Yes, 0-No: ");
            int addInsurance = scanner.nextInt();

            System.out.print("Add WiFi? 1-Yes, 0-No: ");
            int addWifi = scanner.nextInt();

            if (addBreakfast == 1) {
                finalTrip = new BreakfastDecorator(finalTrip);
            }
            if (addInsurance == 1) {
                finalTrip = new InsuranceDecorator(finalTrip);
            }
            if (addWifi == 1) {
                finalTrip = new WifiDecorator(finalTrip);
            }

            System.out.println("\n=== FINAL TRIP INFO ===");
            System.out.println(finalTrip.getDescription());
            System.out.println("Total: $" + finalTrip.getTotalCost());
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