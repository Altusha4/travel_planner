package service;
import adapter.*;
import builder.TripBuilder;
import entities.*;
import java.util.Scanner;

public class TripService {
    public void createTrip() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("From: ");
        String from = scanner.nextLine();

        System.out.print("To: ");
        String to = scanner.nextLine();

        Flight flight = new FlightAdapter().getFlight(from, to);
        Hotel hotel = new HotelAdapter().getHotel(to);

        Trip trip = new TripBuilder()
                .setRoute(new Route(from, to, "standard"))
                .setFlight(flight)
                .setHotel(hotel)
                .build();

        System.out.println("\nYour trip: ");
        System.out.println(trip);

        double total = flight.getPrice() + (hotel.getNights() * hotel.getPricePerNight());
        System.out.println("Total Cost: $" + total);

        scanner.close();
    }
}