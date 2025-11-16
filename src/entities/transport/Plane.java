package entities.transport;

public class Plane implements Transport {
    @Override
    public String getType() {
        return "Plane";
    }
    @Override
    public int getSpeed() {
        return 900;
    }
}