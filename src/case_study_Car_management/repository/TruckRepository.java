package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.module.Motorbike;
import case_study_Car_management.module.Truck;
import case_study_Car_management.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements ITruckRepository {
    private List<Truck> trucks = new ArrayList<>();
    private final String PATH = "truck.cvs";
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
    public void delete(String truckName, String truckLicensePlate) throws VehicleNotFoundException {
        for(int i = 0 ; i < trucks.size();i++){
            if(trucks.get(i).getVehicleName().equals(truckName)
                    && trucks.get(i).getVehicleLicensePlate().equals(truckLicensePlate)){
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
    public void writeToFile(String path, List data) {
        FileUtil.writeText(path, data);

    }

    @Override
    public List readFromFile(String path) {
        return FileUtil.readText(path);
    }
}