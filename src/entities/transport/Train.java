package entities.transport;

public class Train implements Transport {
    @Override
    public String getType() {
        return "Train";
    }
    @Override
    public int getSpeed() {
        return 250;
    }
}