package service;
import adapter.*;
import builder.TripBuilder;
import entities.*;
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

        try {
            Flight flight = new FlightAdapter().getFlight(from, to);
            Hotel hotelBase = new HotelAdapter().getHotel(to);

            if (flight == null || hotelBase == null) {
                System.out.println("Not found");
                return;
            }

            Hotel hotel = new Hotel(hotelBase.getCity(), hotelBase.getName(),
                    nights, hotelBase.getPricePerNight());

            Trip trip = new TripBuilder()
                    .setRoute(new Route(from, to, "standard"))
                    .setFlight(flight)
                    .setHotel(hotel)
                    .build();

            System.out.println("\n" + trip);

            double total = flight.getPrice() + (nights * hotelBase.getPricePerNight());
            System.out.println("Total: $" + total);

        } catch (Exception e) {
            System.out.println("Error");
        }
        scanner.close();
    }
}