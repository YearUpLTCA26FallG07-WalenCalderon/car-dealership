import java.math.BigDecimal;

public class Vehicle  {
    private  int vin;
    private int year;
    private String make;
    private String model;
    private String VehicleTypoe;
    private String color;
    private int odometer;
    private BigDecimal price;

    public Vehicle(int vin, int year, String make, String model, String vehicleTypoe
            , String color, int odometer, BigDecimal price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        VehicleTypoe = vehicleTypoe;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }








    //getters and setters-----------------------------------------------------------------------------------------------|
    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleTypoe() {
        return VehicleTypoe;
    }

    public void setVehicleTypoe(String vehicleTypoe) {
        VehicleTypoe = vehicleTypoe;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
