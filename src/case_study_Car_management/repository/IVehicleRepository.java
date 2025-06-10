package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;
import case_study_Car_management.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository extends IRepository<Vehicle> {
    void delete(String licensePlate) throws VehicleNotFoundException;
    void edit(Vehicle vehicle) throws VehicleNotFoundException;
    List<Vehicle> findByKeyword(String keyword);
    Vehicle findByLicensePlate(String licensePlate);

    List<Vehicle> findByType(int typeId);
}
