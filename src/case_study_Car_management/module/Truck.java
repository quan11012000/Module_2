package case_study_Car_management.module;

public class Truck extends Vehicle{
    public Truck() {
    }

    public Truck(String vehicleName, String vehicleColor, double vehiclePrice, String vehicleLicensePlate,
                 String vehicleManufacturer, String vehicleYearManufacturer, String vehicleDescription) {
        super(vehicleName, vehicleColor, vehiclePrice, vehicleLicensePlate, vehicleManufacturer,
                vehicleYearManufacturer, vehicleDescription);
    }
}
