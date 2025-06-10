package case_study_Car_management.service;

import case_study_Car_management.entity.Vehicle;

import java.util.List;

public interface IVehicleService extends IService<Vehicle> {
    boolean delete(String licensePlate);
    List<Vehicle> findByKeyword(String keyword);

    Vehicle findByLicensePlate(String licensePlate);

    List<Vehicle> findByType(int typeId);
}
