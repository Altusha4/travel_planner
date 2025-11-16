package decorator;

public class InsuranceDecorator extends TripDecorator {

    public InsuranceDecorator(TripComponent trip) {
        super(trip);
    }

    @Override
    public double getTotalCost() {
        return super.getTotalCost() + 45;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Insurance";
    }
}