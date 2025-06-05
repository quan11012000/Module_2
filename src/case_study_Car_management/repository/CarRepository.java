package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.module.Car;
import case_study_Car_management.module.Motorbike;
import case_study_Car_management.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository{
    List<Car> cars = new ArrayList<>();
    private final String PATH = "car.csv";
    public CarRepository(){
        cars = readFromFile(PATH);
    }
    @Override
    public List findAll() {
        return cars;
    }
    @Override
    public void add(Car car) {
        cars.add(car);
        writeToFile(PATH,cars);
    }
    @Override
    public void delete(String carName, String carLicensePlate) throws VehicleNotFoundException {
        for(int i = 0 ; i < cars.size();i++){
            if(cars.get(i).getVehicleName().equals(carName)
                    && cars.get(i).getVehicleLicensePlate().equals(carLicensePlate)){
                cars.remove(i);
                return;
            }
        }
        throw new VehicleNotFoundException();
    }
    @Override
    public void edit(Car car) throws VehicleNotFoundException {
        for(int i = 0 ; i < cars.size();i++){
            if(car.getVehicleLicensePlate().equals(cars.get(i).getVehicleLicensePlate())){
                cars.set(i,car);
                return;
            }
        }
        throw new VehicleNotFoundException();
    }

    @Override
    public List<Car> findByVehicleName(String carName) {
        List<Car> findCarByName = new ArrayList<>();
        for (int i =0 ; i <cars.size();i++){
            if(cars.get(i).getVehicleName().equals(carName)){
                findCarByName.add(cars.get(i));
            }
        }
        return findCarByName;
    }

    @Override
    public void writeToFile(String path, List data) {
        FileUtil.writeText(path, data);

    }

    @Override
    public List readFromFile(String path) {
        return FileUtil.readText(path);
    }
}
