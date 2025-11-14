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

        System.out.print("How many nights: ");
        int nights = scanner.nextInt();
        scanner.nextLine();

        Flight flight = new FlightAdapter().getFlight(from, to);
        Hotel hotelBase = new HotelAdapter().getHotel(to);

        Hotel hotel = new Hotel(hotelBase.getCity(), hotelBase.getName(),
                nights, hotelBase.getPricePerNight());

        Trip trip = new TripBuilder()
                .setRoute(new Route(from, to, "standard"))
                .setFlight(flight)
                .setHotel(hotel)
                .build();

        System.out.println(trip);

        double total = flight.getPrice() + (hotel.getNights() * hotel.getPricePerNight());
        System.out.println("Total cost: $" + total);

        scanner.close();
    }
}