package adapter;
import entities.Flight;
import entities.transport.Transport;

public interface FlightProvider {
    Flight findFlight(String from, String to, Transport transport);
}