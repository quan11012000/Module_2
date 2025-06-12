package test_thi.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    boolean add(T t);
    boolean update(T t);
    boolean delete(int id);
    T findById(int id);
}
