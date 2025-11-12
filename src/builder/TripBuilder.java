package builder;
import entities.*;

public class TripBuilder {
    private Route route;
    private Flight flight;
    private Hotel hotel;

    public TripBuilder setRoute(Route route) {
        this.route = route;
        return this;
    }
    public TripBuilder setFlight(Flight flight) {
        this.flight = flight;
        return this;
    }
    public TripBuilder setHotel(Hotel hotel) {
        this.hotel = hotel;
        return this;
    }
    public Trip build() {
        return new Trip(route, flight, hotel);
    }
}
