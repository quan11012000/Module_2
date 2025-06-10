package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.entity.Vehicle;
import case_study_Car_management.util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleRepository implements IVehicleRepository {
    private final IVehicleTypeRepository vehicleTypeRepository = new VehicleTypeRepository();
    private final String PATH = "E:\\codegym\\module_2\\src\\case_study_Car_management\\data\\vehicles.csv";

    @Override
    public List findAll() {
        return readFromFile(PATH);
    }

    @Override
    public void add(Vehicle vehicle) {
        List<Vehicle> vehicles = findAll();
        vehicles.add(vehicle);
        writeToFile(PATH, vehicles);
    }

    @Override
    public void delete(String licensePlate) throws VehicleNotFoundException {
        List<Vehicle> vehicles = findAll();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getVehicleLicensePlate().equals(licensePlate)) {
                vehicles.remove(i);
                writeToFile(PATH, vehicles);
                return;
            }
        }
        throw new VehicleNotFoundException();
    }

    @Override
    public void edit(Vehicle vehicle) throws VehicleNotFoundException {
        List<Vehicle> vehicles = findAll();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicle.getVehicleLicensePlate().equals(vehicles.get(i).getVehicleLicensePlate())) {
                vehicles.set(i, vehicle);
                writeToFile(PATH, vehicles);
                return;
            }
        }
        throw new VehicleNotFoundException();
    }


    @Override
    public List<Vehicle> readFromFile(String path) {
        List<String> list = FileUtil.readCsvFile(path);
        List<Vehicle> vehicles = new ArrayList<>();
        String[] properties;
        for (String line : list) {
            properties = line.split(",", -1);
            Vehicle vehicle = new Vehicle(
                    properties[0],
                    properties[1],
                    Double.parseDouble(properties[2]),
                    properties[3],
                    properties[4],
                    properties[5],
                    properties[6],
                    Integer.parseInt(properties[7])
            );
            vehicle.setVehicleType(vehicleTypeRepository.findById(vehicle.getVehicleTypeId()));
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    @Override
    public void writeToFile(String path, List<Vehicle> data) {
        List<String> lines = new ArrayList<>();
        for (Vehicle vehicle : data) {
            lines.add(vehicle.toCsvLine());
        }
        FileUtil.writeCsvFile(PATH, lines);
    }

    @Override
    public List<Vehicle> findByKeyword(String keyword) {
        List<Vehicle> vehicles = findAll();
        return vehicles.stream()
                .filter(v -> v.getVehicleName().toLowerCase().contains(keyword) ||
                        v.getVehicleLicensePlate().toLowerCase().contains(keyword))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Vehicle findByLicensePlate(String licensePlate) {
        List<Vehicle> vehicles = findAll();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleLicensePlate().equals(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public List<Vehicle> findByType(int typeId) {
        List<Vehicle> vehicles = findAll();
        return vehicles.stream()
                .filter(v -> v.getVehicleTypeId()==typeId)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
