package case_study_Car_management.module;

public class Vehicle {
    private String vehicleName;
    private String vehicleColor;
    private double vehiclePrice;
    private String vehicleLicensePlate;
    private String vehicleManufacturer;
    private String vehicleYearManufacturer;
    private String vehicleDescription;
    public Vehicle(){

    }
    public Vehicle(String vehicleName, String vehicleColor, double vehiclePrice, String vehicleLicensePlate,
                   String vehicleManufacturer, String vehicleYearManufacturer, String vehicleDescription) {
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
        this.vehiclePrice = vehiclePrice;
        this.vehicleLicensePlate = vehicleLicensePlate;
        this.vehicleManufacturer = vehicleManufacturer;
        this.vehicleYearManufacturer = vehicleYearManufacturer;
        this.vehicleDescription = vehicleDescription;
    }
    public String getInfo() {
        return vehicleName + "," + vehicleColor + "," + vehicleLicensePlate + "," + vehicleManufacturer + ","
                + vehicleYearManufacturer + "," + vehiclePrice + "," + vehicleDescription;
    }
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
    @Override
    public String toString(){
        return "Tên xe: " + vehicleName + ", Màu: " + vehicleColor + ", Biển số: " + vehicleLicensePlate +
                ", Hãng: " + vehicleManufacturer + ", Năm: " + vehicleYearManufacturer +
                ", Giá: " + vehiclePrice + ", Mô tả: " + vehicleDescription;
    }
    public static Vehicle fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 7) {
            return new Motorbike(
                    parts[0], parts[1], Double.parseDouble(parts[2]), parts[3],
                    parts[4], parts[5], parts[6]
            );
        }
        return null;
    }
}
