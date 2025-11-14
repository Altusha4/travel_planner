package entities;

public class Flight {
    private String from;
    private String to;
    private String airline;
    private double price;

    public Flight(String from, String to, String airline, double price) {
        this.from = from;
        this.to = to;
        this.airline = airline;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Flight: " + airline + " from " + from + " to " + to + " at $" + price;
    }
}
