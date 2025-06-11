package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleTypeNotFoundException;
import case_study_Car_management.entity.VehicleType;
import case_study_Car_management.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class VehicleTypeRepository implements IVehicleTypeRepository{
    private final String PATH = "E:\\codegym\\module_2\\src\\case_study_Car_management\\data\\vehicle_type.csv";
    @Override
    public List<VehicleType> findAll() {
        return readFromFile(PATH);
    }

    @Override
    public void add(VehicleType vehicleType) {

    }

    @Override
    public void writeAppendToFile(String path, VehicleType vehicleType) {

    }

    @Override
    public void delete(int id) throws VehicleTypeNotFoundException {

    }

    @Override
    public void edit(VehicleType vehicleType) throws VehicleTypeNotFoundException {

    }

    @Override
    public VehicleType findById(int id) {
        List<VehicleType> vehicleTypes=findAll();
        for(VehicleType vehicleType:vehicleTypes){
            if(vehicleType.getId()==id){
                return vehicleType;
            }
        }
        return null;
    }

    @Override
    public void writeToFile(String path, List<VehicleType> data) {

    }

    @Override
    public List<VehicleType> readFromFile(String path) {
        List<String> list = FileUtil.readCsvFile(path);
        List<VehicleType> vehicleTypes = new ArrayList<>();
        String[] properties;
        for (String line:list){
            properties= line.split(",",-1);
            vehicleTypes.add(new VehicleType(
                    Integer.parseInt(properties[0]),
                    properties[1],
                    properties[2]

            ));
        }
        return vehicleTypes;
    }
}
