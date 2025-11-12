package builder;
import entities.*;

public class TripDirector {
    public Trip buildStandardTrip() {
        return new TripBuilder()
                .setRoute(new Route("Almaty", "Rome", "scenic"))
                .setFlight(new Flight("Almaty", "Rome", "Air Astana", 500.0))
                .setHotel(new Hotel("Rome", "Roma Hotel", 3, 120.0))
                .build();
    }
    public Trip buildCustomTrip(String from, String to, String airline, double price, String hotelName, int nights, double pricePerNight) {
        return new TripBuilder()
                .setRoute(new Route(from, to, "scenic"))
                .setFlight(new Flight(from, to, airline, price))
                .setHotel(new Hotel(to, hotelName, nights, pricePerNight))
                .build();
    }
}
