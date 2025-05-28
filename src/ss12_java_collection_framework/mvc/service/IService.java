package ss12_java_collection_framework.mvc.service;

import java.util.List;

public interface IService <T> {
    List<T> findAll();
    T findById(int id);
    void edit(T t);
    void add(T t);
    void delete(int id);

}
