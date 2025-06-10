package case_study_Car_management.service;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.entity.Vehicle;
import case_study_Car_management.repository.IVehicleRepository;
import case_study_Car_management.repository.VehicleRepository;

import java.util.List;

public class VehicleService implements IVehicleService{
    private final IVehicleRepository vehicleRepository = new VehicleRepository();
    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public boolean add(Vehicle vehicle) {
        vehicleRepository.add(vehicle);
        return true;
    }

    @Override
    public boolean delete(String licensePlate) {
        try {
            vehicleRepository.delete(licensePlate);
            return true;
        } catch (VehicleNotFoundException e) {
            return false;
        }

    }

    @Override
    public boolean edit(Vehicle vehicle){
        try {
            vehicleRepository.edit(vehicle);
            return true;
        } catch (VehicleNotFoundException e) {
            return false;
        }
    }

    @Override
    public List<Vehicle> findByKeyword(String keyword) {
        return vehicleRepository.findByKeyword(keyword);
    }

    @Override
    public Vehicle findByLicensePlate(String licensePlate) {
        return vehicleRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public List<Vehicle> findByType(int typeId) {
        return vehicleRepository.findByType(typeId);
    }
}
