package adapter;
import java.util.Scanner;
import java.io.File;

public class CsvFlightService {
    public String[] findFlightData(String from, String to) throws Exception {
        File file = new File("src/data/flights.csv");
        Scanner scanner = new Scanner(file);

        if (scanner.hasNextLine()) scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            if (data[0].equalsIgnoreCase(from) && data[1].equalsIgnoreCase(to)) {
                scanner.close();
                return data;
            }
        }
        scanner.close();
        return null;
    }
}