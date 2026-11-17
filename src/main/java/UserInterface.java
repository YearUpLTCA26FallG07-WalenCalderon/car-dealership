import java.math.BigDecimal;
import java.util.List;

public class UserInterface {

    private Dealership dealership;

    private final DealershipFileManager fileManager =
            new DealershipFileManager();

    public void display() {

        init();

        while (true) {

            System.out.printf(
                    "%n=== %s ===%n",
                    dealership.getName()
            );

            System.out.println("""
                    1 - Find vehicles within a price range
                    2 - Find vehicles by make / model
                    3 - Find vehicles by year range
                    4 - Find vehicles by color
                    5 - Find vehicles by mileage range
                    6 - Find vehicles by type (car, truck, SUV, van)
                    7 - List ALL vehicles
                    8 - Add a vehicle
                    9 - Remove a vehicle
                    99 - Quit
                    """);

            int choice = Console.promptForInt(
                    "Select your choice: "
            );

            switch (choice) {

                case 1 -> processGetByPriceRequest();

                case 2 -> processGetByMakeModelRequest();

                case 3 -> processGetByYearRequest();

                case 4 -> processGetByColorRequest();

                case 5 -> processGetByMileageRequest();

                case 6 -> processGetByVehicleTypeRequest();

                case 7 -> processGetAllVehiclesRequest();

                case 8 -> processAddVehicleRequest();

                case 9 -> processRemoveVehicleRequest();

                case 99 -> {
                    System.out.println("Goodbye!");
                    return;
                }

                default -> System.out.println(
                        "Invalid option. Try again."
                );
            }
        }
    }

    private void init() {

        this.dealership = fileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.println(
                "VIN | Year | Make | Model | Type | Color | Mileage | Price"
        );

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void processGetByPriceRequest() {

        BigDecimal min = Console.promptForBigDecimal(
                "Minimum price: "
        );

        BigDecimal max = Console.promptForBigDecimal(
                "Maximum price: "
        );

        displayVehicles(
                dealership.getVehiclesByPrice(min, max)
        );
    }

    private void processGetByMakeModelRequest() {

        String make = Console.promptForOptionalString(
                "Make (Enter to skip): "
        );

        String model = Console.promptForOptionalString(
                "Model (Enter to skip): "
        );

        displayVehicles(
                dealership.getVehiclesByMakeModel(make, model)
        );
    }

    private void processGetByYearRequest() {

        int min = Console.promptForInt(
                "Minimum year: "
        );

        int max = Console.promptForInt(
                "Maximum year: "
        );

        displayVehicles(
                dealership.getVehiclesByYear(min, max)
        );
    }

    private void processGetByColorRequest() {

        String color = Console.promptForString(
                "Color: "
        );

        displayVehicles(
                dealership.getVehiclesByColor(color)
        );
    }

    private void processGetByMileageRequest() {

        int min = Console.promptForInt(
                "Minimum mileage: "
        );

        int max = Console.promptForInt(
                "Maximum mileage: "
        );

        displayVehicles(
                dealership.getVehiclesByMileage(min, max)
        );
    }

    private void processGetByVehicleTypeRequest() {

        String type = Console.promptForString(
                "Vehicle type (car, truck, SUV, van): "
        );

        displayVehicles(
                dealership.getVehiclesByType(type)
        );
    }

    private void processGetAllVehiclesRequest() {

        displayVehicles(
                dealership.getAllVehicles()
        );
    }

    private void processAddVehicleRequest() {

        int vin = Console.promptForInt("VIN: ");

        for (Vehicle vehicle : dealership.getAllVehicles()) {

            if (vehicle.getVin() == vin) {

                System.out.println(
                        "A vehicle with that VIN already exists."
                );

                return;
            }
        }

        int year = Console.promptForInt("Year: ");

        String make = Console.promptForString(
                "Make: "
        ).trim();

        String model = Console.promptForString(
                "Model: "
        ).trim();

        String type = Console.promptForString(
                "Type (car, truck, SUV, van): "
        ).trim();

        String color = Console.promptForString(
                "Color: "
        ).trim();

        int mileage = Console.promptForInt(
                "Mileage: "
        );

        BigDecimal price = Console.promptForBigDecimal(
                "Price: "
        );

        if (vin < 0
                || year <= 0
                || mileage < 0
                || price.signum() < 0
                || make.contains("|")
                || model.contains("|")
                || type.contains("|")
                || color.contains("|")) {

            System.out.println(
                    "Invalid vehicle information. Vehicle was not added."
            );

            return;
        }

        Vehicle vehicle = new Vehicle(
                vin,
                year,
                make,
                model,
                type,
                color,
                mileage,
                price
        );

        dealership.addVehicle(vehicle);

        fileManager.saveDealership(dealership);

        System.out.println(
                "Vehicle added and saved."
        );
    }

    private void processRemoveVehicleRequest() {

        int vin = Console.promptForInt(
                "VIN to remove: "
        );

        for (Vehicle vehicle : dealership.getAllVehicles()) {

            if (vehicle.getVin() == vin) {

                dealership.removeVehicle(vehicle);

                fileManager.saveDealership(dealership);

                System.out.println(
                        "Vehicle removed and saved."
                );

                return;
            }
        }

        System.out.println(
                "No vehicle found with that VIN."
        );
    }
}