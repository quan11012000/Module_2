package case_study_Car_management.module;
public abstract class Vehicle {
    protected String vehicleName;
    protected String vehicleColor;
    protected double vehiclePrice;
    protected String vehicleLicensePlate;
    protected String vehicleManufacturer;
    protected String vehicleYearManufacturer;
    protected String vehicleDescription;

    public Vehicle(String vehicleName, String vehicleColor, double vehiclePrice,
                   String vehicleLicensePlate, String vehicleManufacturer,
                   String vehicleYearManufacturer, String vehicleDescription) {
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
        this.vehiclePrice = vehiclePrice;
        this.vehicleLicensePlate = vehicleLicensePlate;
        this.vehicleManufacturer = vehicleManufacturer;
        this.vehicleYearManufacturer = vehicleYearManufacturer;
        this.vehicleDescription = vehicleDescription;
    }

    public String getInfo(){
        return String.join(" || ",getVehicleType(), vehicleName, vehicleColor,String.format("%.0f",vehiclePrice) ,
                vehicleLicensePlate, vehicleManufacturer, vehicleYearManufacturer, vehicleDescription);
    }
    public abstract String getVehicleType();

    // Getters and Setters
    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public void setVehicleLicensePlate(String vehicleLicensePlate) {
        this.vehicleLicensePlate = vehicleLicensePlate;
    }

    public String getVehicleManufacturer() {
        return vehicleManufacturer;
    }

    public void setVehicleManufacturer(String vehicleManufacturer) {
        this.vehicleManufacturer = vehicleManufacturer;
    }

    public String getVehicleYearManufacturer() {
        return vehicleYearManufacturer;
    }

    public void setVehicleYearManufacturer(String vehicleYearManufacturer) {
        this.vehicleYearManufacturer = vehicleYearManufacturer;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }
    public String toCsvLine(){
        return String.join(",", vehicleName, vehicleColor,String.format("%.0f",vehiclePrice) ,
                vehicleLicensePlate, vehicleManufacturer, vehicleYearManufacturer, vehicleDescription);
    }
}