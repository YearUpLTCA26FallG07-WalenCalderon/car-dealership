import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phone;

    private final ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    public List<Vehicle> getVehiclesByPrice(
            BigDecimal minPrice,
            BigDecimal maxPrice) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getPrice().compareTo(minPrice) >= 0
                    && vehicle.getPrice().compareTo(maxPrice) <= 0) {

                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByMakeModel(
            String make,
            String model) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getMake().toLowerCase()
                    .contains(make.trim().toLowerCase())
                    && vehicle.getModel().toLowerCase()
                    .contains(model.trim().toLowerCase())) {

                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByYear(
            int minYear,
            int maxYear) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getYear() >= minYear
                    && vehicle.getYear() <= maxYear) {

                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByColor(String color) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getColor().equalsIgnoreCase(color.trim())) {
                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByMileage(
            int minMileage,
            int maxMileage) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getOdometer() >= minMileage
                    && vehicle.getOdometer() <= maxMileage) {

                results.add(vehicle);
            }
        }

        return results;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {

        List<Vehicle> results = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getVehicleType()
                    .equalsIgnoreCase(vehicleType.trim())) {

                results.add(vehicle);
            }
        }

        return results;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}