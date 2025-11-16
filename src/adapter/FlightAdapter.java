package adapter;
import entities.Flight;
import entities.transport.Transport;

public class FlightAdapter implements FlightProvider {
    private CsvFlightService csvService;

    public FlightAdapter() {
        this.csvService = new CsvFlightService();
    }
    @Override
    public Flight findFlight(String from, String to, Transport transport) {
        try {
            String[] data = csvService.findFlightData(from, to);
            if (data != null) {
                double price = getPriceForTransport(data, transport);
                return new Flight(data[0], data[1], data[2], price);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    private double getPriceForTransport(String[] data, Transport transport) {
        switch (transport.getType()) {
            case "Plane": return Double.parseDouble(data[3]);
            case "Train": return Double.parseDouble(data[4]);
            case "Car": return Double.parseDouble(data[5]);
            case "Bus": return Double.parseDouble(data[6]);
            default: return Double.parseDouble(data[3]);
        }
    }
}