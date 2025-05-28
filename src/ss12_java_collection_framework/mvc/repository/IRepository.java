package ss12_java_collection_framework.mvc.repository;

import ss12_java_collection_framework.mvc.model.Product;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    T findById(int id);
    void edit(T t);
    void add(T t);
    void delete(int id);


}
