package case_study_Car_management.service;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.module.Car;
import case_study_Car_management.module.Motorbike;
import case_study_Car_management.repository.CarRepository;
import case_study_Car_management.repository.ICarRepository;


import java.util.List;

public class CarService implements ICarService{
    ICarRepository iCarRepository = new CarRepository();
    @Override
    public List<Car> findAll() {
        return iCarRepository.findAll();
    }

    @Override
    public boolean add(Car car) {
        iCarRepository.add(car);
        return true;
    }

    @Override
    public boolean delete( String LicensePlate) {
        try{
            iCarRepository.delete(LicensePlate);
            return true;
        }catch (VehicleNotFoundException e){
            return false;
        }
    }
    @Override
    public boolean edit(Car car) throws VehicleNotFoundException {
        try{
            iCarRepository.edit(car);
            return true;
        }catch (VehicleNotFoundException e){
            return false;
        }
    }
    @Override
    public List<Car> findByVehicleName(String carName) {
        return iCarRepository.findByVehicleName(carName);
    }
    @Override
    public void writeToFile(String path, List<Car> data) {
        iCarRepository.writeToFile(path,data);
    }
    @Override
    public List<Car> readFromFile(String path) {
        return iCarRepository.readFromFile(path);
    }
}
