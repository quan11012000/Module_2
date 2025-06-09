package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.module.Car;
import case_study_Car_management.module.Motorbike;
import case_study_Car_management.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository{

    private final String PATH = "E:\\codegym\\module_2\\src\\case_study_Car_management\\data\\cars.csv";

    @Override
    public List findAll() {
        return readFromFile(PATH);
    }
    @Override
    public void add(Car car) {
        List<Car> cars = findAll();
        cars.add(car);
        writeToFile(PATH,cars);
    }
    @Override
    public void delete( String carLicensePlate) throws VehicleNotFoundException {
        List<Car> cars = findAll();
        for(int i = 0 ; i < cars.size();i++){
            if( cars.get(i).getVehicleLicensePlate().equals(carLicensePlate)){
                cars.remove(i);
                writeToFile(PATH,cars);
                return;
            }
        }
        throw new VehicleNotFoundException();
    }
    @Override
    public void edit(Car car) throws VehicleNotFoundException {
        List<Car> cars = findAll();
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
        List<Car> cars = findAll();
        List<Car> findCarByName = new ArrayList<>();
        for (int i =0 ; i <cars.size();i++){
            if(cars.get(i).getVehicleName().equals(carName)){
                findCarByName.add(cars.get(i));
            }
        }
        return findCarByName;
    }

    @Override
    public List<Car> readFromFile(String path) {
        List<String> list = FileUtil.readCsvFile(path);
        List<Car> cars = new ArrayList<>();
        String[] properties;
        for (String line:list){
            properties= line.split(",");
            cars.add(new Car(
                    properties[0],
                    properties[1],
                    Double.parseDouble(properties[2]),
                    properties[3],
                    properties[4],
                    properties[5],
                    properties[6]
            ));
        }
        return cars;
    }

    @Override
    public void writeToFile(String path, List<Car> data) {
        List<String> lines = new ArrayList<>();
        for (Car car : data){
            lines.add(car.toCsvLine());
        }
        FileUtil.writeCsvFile(PATH,lines);
    }
}
