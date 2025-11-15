package observer;

import entities.Trip;
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
    public void notifyTripCreated(Trip trip){
        notifyObservers("New trip is created: " + trip.summary());
    }
    public void notifyTripUpdated(Trip trip){
        notifyObservers("Trip updated: " + trip.summary());
    }
}
