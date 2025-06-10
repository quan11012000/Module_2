package case_study_Car_management.service;

import case_study_Car_management.common.exceptions.VehicleNotFoundException;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    boolean add(T t);
    boolean edit(T t);


}
