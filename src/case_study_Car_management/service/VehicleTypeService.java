package case_study_Car_management.service;

import case_study_Car_management.common.exceptions.VehicleTypeNotFoundException;
import case_study_Car_management.entity.VehicleType;
import case_study_Car_management.repository.IVehicleTypeRepository;
import case_study_Car_management.repository.VehicleTypeRepository;

import java.util.List;

public class VehicleTypeService implements IVehicleTypeService{
    private final IVehicleTypeRepository vehicleTypeRepository = new VehicleTypeRepository();
    @Override
    public List<VehicleType> findAll() {
        return vehicleTypeRepository.findAll();
    }

    @Override
    public boolean add(VehicleType vehicleType) {
        vehicleTypeRepository.add(vehicleType);
        return true;
    }

    @Override
    public boolean delete(int id) {
        try{
            vehicleTypeRepository.delete(id);
            return true;
        } catch (VehicleTypeNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean edit(VehicleType vehicleType) {
        try {
            vehicleTypeRepository.edit(vehicleType);
            return true;
        } catch (VehicleTypeNotFoundException e) {
            return false;
        }
    }
}
