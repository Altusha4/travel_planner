package decorator;

public abstract class TripDecorator implements TripComponent {

    protected TripComponent trip;

    public TripDecorator(TripComponent trip) {
        this.trip = trip;
    }

    @Override
    public double getTotalCost() {
        return trip.getTotalCost();
    }

    @Override
    public String getDescription() {
        return trip.getDescription();
    }
}