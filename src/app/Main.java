package app;
import service.TripService;

public class Main {
    public static void main(String[] args) throws Exception {
        TripService tripService = new TripService();
        tripService.createTrip();
    }
}