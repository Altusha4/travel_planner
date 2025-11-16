package observer;

import decorator.TripComponent;
import java.util.ArrayList;
import java.util.List;

public class TripNotifier implements Subject{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(String message){
        for(Observer observer: observers){
            observer.update(message);
        }
    }
    public void notifyTripCreated(TripComponent trip){
        String message = "Trip created: " + trip.getDescription()
            + " | Total: $" + trip.getTotalCost();
            notifyObservers(message);
    }
    public void notifyTripUpdated(TripComponent trip){
        String message = "Trip updated: " + trip.getDescription()
            + " | Total: $" + trip.getTotalCost();
            notifyObservers(message);
    }
}
