package entities.transport;

public class Car implements Transport {
    @Override
    public String getType() {
        return "Car";
    }
    @Override
    public int getSpeed() {
        return 85;
    }
}