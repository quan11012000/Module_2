package case_study_Car_management.entity;
public class Vehicle {
    private String vehicleName;
    private String vehicleColor;
    private double vehiclePrice;
    private String vehicleLicensePlate;
    private String vehicleManufacturer;
    private String vehicleYearManufacturer;
    private String vehicleDescription;
    private int vehicleTypeId;
    private VehicleType vehicleType;

    public Vehicle(String vehicleName, String vehicleColor, double vehiclePrice, String vehicleLicensePlate, String vehicleManufacturer,
                   String vehicleYearManufacturer, String vehicleDescription, int vehicleTypeId) {
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
        this.vehiclePrice = vehiclePrice;
        this.vehicleLicensePlate = vehicleLicensePlate;
        this.vehicleManufacturer = vehicleManufacturer;
        this.vehicleYearManufacturer = vehicleYearManufacturer;
        this.vehicleDescription = vehicleDescription;
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getInfo() {
        return String.format(
                "| %-15s | %-20s | %-10s | %-12.0f | %-12s | %-15s | %-4s | %-30s |",
                vehicleType.getName(), vehicleName, vehicleColor, vehiclePrice,
                vehicleLicensePlate, vehicleManufacturer, vehicleYearManufacturer, vehicleDescription
        );
    }


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

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String toCsvLine(){
        return String.join(",", vehicleName, vehicleColor,String.format("%.0f",vehiclePrice) ,
                vehicleLicensePlate, vehicleManufacturer, vehicleYearManufacturer, vehicleDescription,String.format("%d",vehicleTypeId));
    }
}