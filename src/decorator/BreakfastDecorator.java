package decorator;

public class BreakfastDecorator extends TripDecorator {

    public BreakfastDecorator(TripComponent trip) {
        super(trip);
    }

    @Override
    public double getTotalCost() {
        return super.getTotalCost() + 20;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Breakfast";
    }
}