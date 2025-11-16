package app;

import observer.TripNotifier;
import observer.User;
import service.TripService;

public class Main {
    public static void main(String[] args) {
        TripNotifier notifier = new TripNotifier();

        User nuray = new User("Nuray");
        User altynay = new User("Altynay");
        User zaure = new User("Zaure");

        notifier.addObserver(nuray);
        notifier.addObserver(altynay);
        notifier.addObserver(zaure);

        notifier.removeObserver(nuray);

        TripService tripService = new TripService(notifier);
        tripService.createTrip();
    }
}