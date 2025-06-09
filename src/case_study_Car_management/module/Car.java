package case_study_Car_management.module;

public class Car extends Vehicle{


    public Car(String vehicleName, String vehicleColor, double vehiclePrice, String vehicleLicensePlate,
               String vehicleManufacturer, String vehicleYearManufacturer, String vehicleDescription) {
        super(vehicleName, vehicleColor, vehiclePrice, vehicleLicensePlate, vehicleManufacturer,
                vehicleYearManufacturer, vehicleDescription);
    }

        @Override
        public String getVehicleType() {
            return "Ô tô";
        }
    }


