import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private static ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public static List<Vehicle> getVehiclesByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
//todo
        return null;
    }

    public static List<Vehicle> getVehiclesByMakeModel(String make, String model) {
//todo
        return null;
    }

    public static List<Vehicle> getVehiclesByYear(int minYear, int maxYear){
//todo
        return null;
    }

    public static List<Vehicle> getVehiclesByColor(String color) {
        //todo
        return null;
    }

    public static List<Vehicle> getVehiclesByMileage(double minMileage, double maxMileage) {
        //todo
        return null;
    }

    public static List<Vehicle> getVehiclesByType(String vehicleType) {
        //todo
        return null;
    }

    public static List<Vehicle> getAllVehicles() {
//        List<Vehicle> vehicle = new ArrayList<>(inventory);
//        return vehicle; //todo
        return null;
    }

    public void addVehicle(Vehicle vehicle) {
//        if("add"){
//            inventory.add(vehicle); //todo
//        }

    }

    public void removeVehicle(Vehicle vehicle) {
//        if(inventory.contains(vehicle)){
//            inventory.remove(vehicle);
//        }]

    }


    //This method does not belong here but we prolly use it

    /*public static ArrayList <Product> searchByPriceRange(double maxPrice, double minPrice, ArrayList <Product> inventory){
        ArrayList<Product> productInRange = new ArrayList<>();
        for(int i = 0; i < inventory.size(); i++){
            Product product = inventory.get(i);


            if(product.getPrice() > minPrice &&
                    product.getPrice() < maxPrice){
                productInRange.add(product);
            }


        }
        return productInRange;

    }//end of search by price range*/




}
