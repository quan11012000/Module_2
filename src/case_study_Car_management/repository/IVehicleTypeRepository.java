package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleTypeNotFoundException;
import case_study_Car_management.entity.VehicleType;

public interface IVehicleTypeRepository extends IRepository<VehicleType> {
    void delete(int id) throws VehicleTypeNotFoundException;
    void edit(VehicleType vehicleType) throws VehicleTypeNotFoundException;
    VehicleType findById(int id);
}
