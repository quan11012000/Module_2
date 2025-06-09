package case_study_Car_management.module;

public class Truck extends Vehicle{

    public Truck(String vehicleName, String vehicleColor, double vehiclePrice, String vehicleLicensePlate,
                 String vehicleManufacturer, String vehicleYearManufacturer, String vehicleDescription) {
        super(vehicleName, vehicleColor, vehiclePrice, vehicleLicensePlate, vehicleManufacturer,
                vehicleYearManufacturer, vehicleDescription);
    }
    public static Truck fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 7) {
            return new Truck(
                    parts[0], parts[1], Double.parseDouble(parts[2]), parts[3],
                    parts[4],
                    parts[5],
                    parts[6]
            );
        }
        return null;
    }
        @Override
        public String getVehicleType() {
            return "Xe tải";
        }
    }


