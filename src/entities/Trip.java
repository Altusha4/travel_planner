package entities;
import decorator.TripComponent;

public class Trip implements TripComponent {
    private Route route;
    private Flight flight;
    private Hotel hotel;

    public Trip(Route route, Flight flight, Hotel hotel) {
        this.route = route;
        this.flight = flight;
        this.hotel = hotel;
    }
    public Route getRoute(){
        return route;
    }
    public Flight getFlight(){
        return flight;
    }
    public Hotel getHotel(){
        return hotel;
    }
    public String summary(){
        return route.toString() + ", " + hotel.getName() + " (" + hotel.getCity() +")";
    }
    @Override
    public String toString() {
        return  "Route: " + route + "\n" +
                "Flight: " + flight + "\n" +
                "Hotel: " + hotel;
    }
    @Override
    public double getTotalCost() {
        return flight.getPrice() + (hotel.getNights() * hotel.getPricePerNight());
    }

    @Override
    public String getDescription() {
        return summary();
    }
}