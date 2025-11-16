package entities.transport;

public class Bus implements Transport {
    @Override
    public String getType() {
        return "Bus";
    }
    @Override
    public int getSpeed() {
        return 75;
    }
}