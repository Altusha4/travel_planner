package entities;

public class Trip {
    private Route route;
    private Flight flight;
    private Hotel hotel;

    public Trip(Route route, Flight flight, Hotel hotel) {
        this.route = route;
        this.flight = flight;
        this.hotel = hotel;
    }
    public Route getRoute() {
        return route;
    }
    public Flight getFlight() {
        return flight;
    }
    public Hotel getHotel() {
        return hotel;
    }
}
