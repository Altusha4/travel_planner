package service;

import adapter.FlightAdapter;
import adapter.HotelAdapter;
import builder.TripBuilder;
import entities.Flight;
import entities.Hotel;
import entities.Route;
import entities.Trip;
import strategy.BeautifulRoute;
import strategy.FastestRoute;
import strategy.RoutePlanner;
import strategy.SafestRoute;
import observer.TripNotifier;
import observer.User;

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

        System.out.println("\nChoose route type:");
        System.out.println("1 - Fastest");
        System.out.println("2 - Beautiful");
        System.out.println("3 - Safest");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        RoutePlanner planner = new RoutePlanner();
        switch (choice) {
            case 1 -> planner.setStrategy(new FastestRoute());
            case 2 -> planner.setStrategy(new BeautifulRoute());
            case 3 -> planner.setStrategy(new SafestRoute());
            default -> {
                System.out.println("Unknown option, using Fastest by default.");
                planner.setStrategy(new FastestRoute());
            }
        }
        Route route = planner.buildRoute(from, to);

        try {
            Flight flight = new FlightAdapter().getFlight(from, to);
            Hotel hotelBase = new HotelAdapter().getHotel(to);

            if (flight == null || hotelBase == null) {
                System.out.println("Not found");
                return;
            }

            Hotel hotel = new Hotel(
                    hotelBase.getCity(),
                    hotelBase.getName(),
                    nights,
                    hotelBase.getPricePerNight()
            );

            Trip trip = new TripBuilder()
                    .setRoute(route)
                    .setFlight(flight)
                    .setHotel(hotel)
                    .build();

            System.out.println("\n" + trip);

            double total = flight.getPrice() + (nights * hotelBase.getPricePerNight());
            System.out.println("Total: $" + total + "\n");

            System.out.println("Notifying subscribers: ");
            TripNotifier notifier = new TripNotifier();
            notifier.addObserver(new User("Nuray"));
            notifier.addObserver(new User("Altynay"));
            notifier.addObserver(new User("Zaure"));

            notifier.notifyTripCreated(trip);

            //notifyTripUpdated(decoratedTrip);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
