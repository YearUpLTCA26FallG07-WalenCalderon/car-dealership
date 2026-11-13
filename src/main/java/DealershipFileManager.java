import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public static Dealership getDealership() {

    try (BufferedReader reader = new BufferedReader(
            new FileReader("src/main/resources/inventory.csv"))) {

        // Read dealership information
        String line = reader.readLine();

        if (line == null) {
            throw new IOException("Inventory file is empty");
        }

        String[] dealershipData = line.split("\\|");

        String name = dealershipData[0];
        String address = dealershipData[1];
        String phone = dealershipData[2];

        // Create dealership object
        Dealership dealership = new Dealership(name, address, phone);

        // Read vehicles
        while ((line = reader.readLine()) != null) {

            String[] tokens = line.split("\\|");

            int vin = Integer.parseInt(tokens[0]);
            int year = Integer.parseInt(tokens[1]);
            String make = tokens[2];
            String model = tokens[3];
            String vehicleType = tokens[4];
            String color = tokens[5];
            int odometer = Integer.parseInt(tokens[6]);
            BigDecimal price = new BigDecimal(tokens[7]);

            Vehicle vehicle = new Vehicle(
                    vin,
                    year,
                    make,
                    model,
                    vehicleType,
                    color,
                    odometer,
                    price
            );

            dealership.addVehicle(vehicle);
        }

        return dealership;

    } catch (IOException e) {
        throw new RuntimeException("Error reading dealership: " + e.getMessage(), e);
    }
}

    public static void saveDealership(Dealership dealership) {
        try (FileWriter writer = new FileWriter(
                "src/main/resources/inventory.csv")) {

            // Save dealership information
            String dealershipInfo = String.format(
                    "%s|%s|%s%n",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhone()
            );

            writer.write(dealershipInfo);

            // Save every vehicle
            for (Vehicle vehicle : dealership.getAllVehicles()) {

                String line = String.format(
                        "%d|%d|%s|%s|%s|%s|%d|%s%n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice().toPlainString()
                );

                writer.write(line);
            }

        } catch (IOException e) {
            System.out.println("Error saving dealership: " + e.getMessage());
        }
    }
}
