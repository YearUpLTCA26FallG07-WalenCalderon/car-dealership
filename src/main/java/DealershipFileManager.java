import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DealershipFileManager {

    private static final Path FILE_PATH =
            Path.of("src/main/resources/inventory.csv");

    public Dealership getDealership() {

        try (BufferedReader reader = Files.newBufferedReader(
                FILE_PATH, StandardCharsets.UTF_8)) {

            String line = reader.readLine();

            if (line == null) {
                throw new IOException("Inventory file is empty.");
            }

            String[] info = line.split("\\|", -1);

            if (info.length != 3) {
                throw new IOException(
                        "Invalid dealership information in first line.");
            }

            Dealership dealership = new Dealership(
                    info[0],
                    info[1],
                    info[2]
            );

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.split("\\|", -1);

                if (parts.length != 8) {
                    throw new IOException(
                            "Invalid vehicle record: " + line);
                }

                Vehicle vehicle = new Vehicle(
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5],
                        Integer.parseInt(parts[6]),
                        new BigDecimal(parts[7])
                );

                dealership.addVehicle(vehicle);
            }

            return dealership;

        } catch (IOException | NumberFormatException e) {

            throw new IllegalStateException(
                    "Could not load inventory.csv: " + e.getMessage(), e);
        }
    }

    public void saveDealership(Dealership dealership) {

        try {

            Files.createDirectories(FILE_PATH.getParent());

            try (BufferedWriter writer = Files.newBufferedWriter(
                    FILE_PATH, StandardCharsets.UTF_8)) {

                writer.write(String.join(
                        "|",
                        dealership.getName(),
                        dealership.getAddress(),
                        dealership.getPhone()
                ));

                writer.newLine();

                for (Vehicle vehicle : dealership.getAllVehicles()) {

                    writer.write(String.format(
                            "%d|%d|%s|%s|%s|%s|%d|%s",
                            vehicle.getVin(),
                            vehicle.getYear(),
                            vehicle.getMake(),
                            vehicle.getModel(),
                            vehicle.getVehicleType(),
                            vehicle.getColor(),
                            vehicle.getOdometer(),
                            vehicle.getPrice().toPlainString()
                    ));

                    writer.newLine();
                }
            }

        } catch (IOException e) {

            throw new IllegalStateException(
                    "Could not save inventory.csv: " + e.getMessage(), e);
        }
    }
}