package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.module.Car;
import case_study_Car_management.module.Motorbike;
import case_study_Car_management.util.FileUtil;
import java.util.ArrayList;
import java.util.List;

public class MotorbikeRepository implements IMotorbikeRepository{
    private List<Motorbike> motorbikes = new ArrayList<>();
    private final String PATH = "E:\\codegym\\module_2\\src\\case_study_Car_management\\data\\motorbikes.csv";
    public MotorbikeRepository(){
        motorbikes = readFromFile(PATH);
    }
    @Override
    public List findAll() {
        return motorbikes;
    }
    @Override
    public void add(Motorbike motorbike) {
        motorbikes.add(motorbike);
        writeToFile(PATH,motorbikes);
    }
    @Override
    public void delete( String motorbikeLicensePlate) throws VehicleNotFoundException {
        for(int i = 0 ; i < motorbikes.size();i++){
            if( motorbikes.get(i).getVehicleLicensePlate().equals(motorbikeLicensePlate)){
                motorbikes.remove(i);
                writeToFile(PATH,motorbikes);
                return;
            }
        }
        throw new VehicleNotFoundException();
    }
    @Override
    public void edit(Motorbike motorbike) throws VehicleNotFoundException {
        for(int i = 0 ; i < motorbikes.size();i++){
            if(motorbike.getVehicleLicensePlate().equals(motorbikes.get(i).getVehicleLicensePlate())){
                motorbikes.set(i,motorbike);
                writeToFile(PATH,motorbikes);
                return;
            }
        }
        throw new VehicleNotFoundException();
    }

    @Override
    public List<Motorbike> findByVehicleName(String motorbikeName) {
        List<Motorbike> motorbikeFindMotobikes = new ArrayList<>();
        for (int i =0 ; i <motorbikes.size();i++){
            if(motorbikes.get(i).getVehicleName().equals(motorbikeName)){
                motorbikeFindMotobikes.add(motorbikes.get(i));
            }
        }
        return motorbikeFindMotobikes;
    }

    @Override
    public List<Motorbike> readFromFile(String path) {
        List<String> list = FileUtil.readCsvFile(path);
        List<Motorbike> motorbikes = new ArrayList<>();
        String[] properties;
        for (String line:list){
            properties= line.split(",");
            motorbikes.add(new Motorbike(
                    properties[0],
                    properties[1],
                    Double.parseDouble(properties[2]),
                    properties[3],
                    properties[4],
                    properties[5],
                    properties[6]
            ));
        }
        return motorbikes;
    }

    @Override
    public void writeToFile(String path, List<Motorbike> data) {
        List<String> lines = new ArrayList<>();
        for (Motorbike motorbike : data){
            lines.add(motorbike.toCsvLine());
        }
        FileUtil.writeCsvFile(PATH,lines);
    }
}
