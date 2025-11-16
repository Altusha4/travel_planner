package adapter;
import entities.Hotel;

public interface HotelProvider {
    Hotel findHotel(String city, int nights);
}