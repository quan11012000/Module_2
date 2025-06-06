package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.module.Motorbike;
import case_study_Car_management.util.FileUtil;
import java.util.ArrayList;
import java.util.List;

public class MotorbikeRepository implements IMotorbikeRepository{
    private List<Motorbike> motorbikes = new ArrayList<>();
    private final String PATH = "motorbike.cvs";
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
    public void delete(String motorbikeName, String motorbikeLicensePlate) throws VehicleNotFoundException {
        for(int i = 0 ; i < motorbikes.size();i++){
            if(motorbikes.get(i).getVehicleName().equals(motorbikeName)
                && motorbikes.get(i).getVehicleLicensePlate().equals(motorbikeLicensePlate)){
                motorbikes.remove(i);
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
    public void writeToFile(String path, List data) {
        FileUtil.writeText(path, data);

    }

    @Override
    public List readFromFile(String path) {
        return FileUtil.readText(path);
    }
}
