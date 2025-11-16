package decorator;

public class WifiDecorator extends TripDecorator {

    public WifiDecorator(TripComponent trip) {
        super(trip);
    }

    @Override
    public double getTotalCost() {
        return super.getTotalCost() + 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + WiFi";
    }
}