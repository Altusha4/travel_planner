package adapter;
import entities.Hotel;
import java.util.Scanner;
import java.io.File;

public class HotelAdapter {
    public Hotel getHotel(String city) throws Exception {

        File file = new File("src/data/hotels.csv");
        Scanner scanner = new Scanner(file);

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");

            if (data[0].equalsIgnoreCase(city)) {
                scanner.close();
                return new Hotel(data[0], data[1],
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]));
            }
        }
        scanner.close();
        return null;
    }
}