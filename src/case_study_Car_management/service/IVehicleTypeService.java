package case_study_Car_management.service;

import case_study_Car_management.entity.Vehicle;
import case_study_Car_management.entity.VehicleType;

public interface IVehicleTypeService extends IService<VehicleType> {
    boolean delete(int id);
}
