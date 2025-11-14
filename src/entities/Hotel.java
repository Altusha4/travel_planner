package entities;

public class Hotel {
    private String city;
    private String name;
    private int nights;
    private double pricePerNight;

    public Hotel(String city, String name, int nights, double pricePerNight) {
        this.city = city;
        this.name = name;
        this.nights = nights;
        this.pricePerNight = pricePerNight;
    }
    public String getCity() {
        return city;
    }
    public String getName() {
        return name;
    }
    public int getNights() {
        return nights;
    }
    public double getPricePerNight() {
        return pricePerNight;
    }
    public String toString() {
        return "Hotel: " + name + " in " + city + " for " + nights + " nights at $" + pricePerNight + " per night";
    }
}