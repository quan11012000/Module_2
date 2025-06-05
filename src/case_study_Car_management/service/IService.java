package case_study_Car_management.service;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    boolean add(T t);
    boolean delete(String vehicleName,String LicensePlate);
    boolean edit(T t) throws VehicleNotFoundException;
    List<T> findByVehicleName(String vehicleName);
    void writeToFile(String path, List<T> data);
    List<T> readFromFile(String path);
}
