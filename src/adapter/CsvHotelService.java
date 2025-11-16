package adapter;
import java.util.Scanner;
import java.io.File;

public class CsvHotelService {
    public String[] findHotelData(String city) throws Exception {
        File file = new File("src/data/hotels.csv");
        Scanner scanner = new Scanner(file);

        if (scanner.hasNextLine()) scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            if (data[0].equalsIgnoreCase(city)) {
                scanner.close();
                return data;
            }
        }
        scanner.close();
        return null;
    }
}