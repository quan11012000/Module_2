package case_study_Car_management.service;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.module.Motorbike;
import case_study_Car_management.repository.IMotorbikeRepository;
import case_study_Car_management.repository.IRepository;
import case_study_Car_management.repository.MotorbikeRepository;

import java.util.List;

public class MotorbikeService implements IMotorbikeService{
    IMotorbikeRepository iMotorbikeRepository = new MotorbikeRepository();
    @Override
    public List<Motorbike> findAll() {
        return iMotorbikeRepository.findAll();
    }

    @Override
    public boolean add(Motorbike motorbike) {
            iMotorbikeRepository.add(motorbike);
            return true;
    }

    @Override
    public boolean delete(String vehicleName, String LicensePlate) {
        try{
            iMotorbikeRepository.delete(vehicleName,LicensePlate);
            return true;
        }catch (VehicleNotFoundException e){
            return false;
        }
    }
    @Override
    public boolean edit(Motorbike motorbike) throws VehicleNotFoundException {
        try{
            iMotorbikeRepository.edit(motorbike);
            return true;
        }catch (VehicleNotFoundException e){
            return false;
        }
    }
    @Override
    public List<Motorbike> findByVehicleName(String vehicleName) {
        return iMotorbikeRepository.findByVehicleName(vehicleName);
    }
    @Override
    public void writeToFile(String path, List<Motorbike> data) {
        iMotorbikeRepository.writeToFile(path,data);
    }
    @Override
    public List<Motorbike> readFromFile(String path) {
        return iMotorbikeRepository.readFromFile(path);
    }
}
