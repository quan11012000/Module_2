package test_thi.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    boolean add(T t);
    boolean update(T t);
    boolean delete(int id);
    T findById(int id);
    List<T> findByName(String name);
}
