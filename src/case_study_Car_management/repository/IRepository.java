package case_study_Car_management.repository;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    void add(T t);
    void writeAppendToFile(String path, T t);
    void writeToFile(String path, List<T> data);
    List<T> readFromFile(String path);
}
