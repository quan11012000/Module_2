package case_study_Car_management.service;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.module.Motorbike;
import case_study_Car_management.module.Truck;
import case_study_Car_management.repository.IMotorbikeRepository;
import case_study_Car_management.repository.ITruckRepository;
import case_study_Car_management.repository.MotorbikeRepository;
import case_study_Car_management.repository.TruckRepository;

import java.util.List;

public class TruckService implements ITruckService{
    ITruckRepository iTruckRepository = new TruckRepository();
    @Override
    public List<Truck> findAll() {
        return iTruckRepository.findAll();
    }

    @Override
    public boolean add(Truck truck) {
        iTruckRepository.add(truck);
        return true;
    }

    @Override
    public boolean delete(String vehicleName, String LicensePlate) {
        try{
            iTruckRepository.delete(vehicleName,LicensePlate);
            return true;
        }catch (VehicleNotFoundException e){
            return false;
        }
    }
    @Override
    public boolean edit(Truck truck) throws VehicleNotFoundException {
        try{
            iTruckRepository.edit(truck);
            return true;
        }catch (VehicleNotFoundException e){
            return false;
        }
    }
    @Override
    public List<Truck> findByVehicleName(String vehicleName) {
        return iTruckRepository.findByVehicleName(vehicleName);
    }
    @Override
    public void writeToFile(String path, List<Truck> data) {
        iTruckRepository.writeToFile(path,data);
    }
    @Override
    public List<Truck> readFromFile(String path) {
        return iTruckRepository.readFromFile(path);
    }
}
