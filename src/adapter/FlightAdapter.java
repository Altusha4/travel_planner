package adapter;
import entities.Flight;
import java.util.Scanner;
import java.io.File;

public class FlightAdapter {
    public Flight getFlight(String from, String to) throws Exception {

        File file = new File("src/data/flights.csv");
        Scanner scanner = new Scanner(file);

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");

            if (data[0].equalsIgnoreCase(from) && data[1].equalsIgnoreCase(to)) {
                scanner.close();
                return new Flight(data[0], data[1], data[2],
                        Double.parseDouble(data[3]));
            }
        }
        scanner.close();
        return null;
    }
}