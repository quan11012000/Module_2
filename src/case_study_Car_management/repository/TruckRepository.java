package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.module.Car;
import case_study_Car_management.module.Motorbike;
import case_study_Car_management.module.Truck;
import case_study_Car_management.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements ITruckRepository {
    private List<Truck> trucks = new ArrayList<>();
    private final String PATH = "E:\\codegym\\module_2\\src\\case_study_Car_management\\data\\trucks.csv";
    public TruckRepository(){
        trucks = readFromFile(PATH);
    }
    @Override
    public List findAll() {
        return trucks;
    }
    @Override
    public void add(Truck truck) {
        trucks.add(truck);
        writeToFile(PATH,trucks);
    }
    @Override
    public void delete( String truckLicensePlate) throws VehicleNotFoundException {
        for(int i = 0 ; i < trucks.size();i++){
            if(trucks.get(i).getVehicleLicensePlate().equals(truckLicensePlate)){
                trucks.remove(i);
                return;
            }
        }
        throw new VehicleNotFoundException();
    }
    @Override
    public void edit(Truck truck) throws VehicleNotFoundException {
        for(int i = 0 ; i < trucks.size();i++){
            if(truck.getVehicleLicensePlate().equals(trucks.get(i).getVehicleLicensePlate())){
                trucks.set(i,truck);
                return;
            }
        }
        throw new VehicleNotFoundException();
    }

    @Override
    public List<Truck> findByVehicleName(String truckName) {
        List<Truck> findTruckByName = new ArrayList<>();
        for (int i =0 ; i <trucks.size();i++){
            if(trucks.get(i).getVehicleName().equals(truckName)){
                findTruckByName.add(trucks.get(i));
            }
        }
        return findTruckByName;
    }

    @Override
    public List<Truck> readFromFile(String path) {
        List<String> list = FileUtil.readCsvFile(path);
        List<Truck> trucks= new ArrayList<>();
        String[] properties;
        for (String line:list){
            properties= line.split(",");
            trucks.add(new Truck(
                    properties[0],
                    properties[1],
                    Double.parseDouble(properties[2]),
                    properties[3],
                    properties[4],
                    properties[5],
                    properties[6]
            ));
        }
        return trucks;
    }

    @Override
    public void writeToFile(String path, List<Truck> data) {
        List<String> lines = new ArrayList<>();
        for (Truck truck : data){
            lines.add(truck.toCsvLine());
        }
        FileUtil.writeCsvFile(PATH,lines);
    }
}