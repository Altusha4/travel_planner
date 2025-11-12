package builder;
import entities.*;

public class TripDirector {
    private TripBuilder builder;

    public TripDirector(TripBuilder builder) {
        this.builder = builder;
    }
    public Trip createStandardTrip() {
        Route route = new Route("Astana", "Rome", "scenic");
        Flight flight = new Flight("Astana", "Rome", "Air Astana", 500.0);
        Hotel hotel = new Hotel("Rome", "Roma Hotel", 3, 120.0);

        return builder.setRoute(route)
                      .setFlight(flight)
                      .setHotel(hotel)
                      .build();
    }
    public Trip createCustomTrip(String from, String to) {
        Route route = new Route(from, to, "scenic");
        Flight flight = new Flight(from, to, "Air Astana", 600.0);
        Hotel hotel = new Hotel(to, "Hotel Example", 4, 150.0);

        return builder.setRoute(route)
                .setFlight(flight)
                .setHotel(hotel)
                .build();
    }
}
