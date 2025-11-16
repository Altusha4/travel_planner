package adapter;
import entities.Hotel;

public class HotelAdapter implements HotelProvider {
    private CsvHotelService csvService;

    public HotelAdapter() {
        this.csvService = new CsvHotelService();
    }
    @Override
    public Hotel findHotel(String city, int nights) {
        try {
            String[] data = csvService.findHotelData(city);
            if (data != null) {
                return new Hotel(data[0], data[1], nights, Double.parseDouble(data[2]));
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}