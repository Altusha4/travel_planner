package entities;

public class Flight {
    private String from;
    private String to;
    private String company;
    private double price;

    public Flight(String from, String to, String company, double price) {
        this.from = from;
        this.to = to;
        this.company = company;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public String toString() {
        return company + " from " + from + " to " + to + " at $" + price;
    }
}
