package ss12_java_collection_framework.mvc.repository;

import ss12_java_collection_framework.mvc.model.Product;

import java.util.List;

public interface IProductRepository extends IRepository<Product> {
    List<Product> sortByPrice(boolean ascending);
    List<Product> sortByName(boolean ascending);

}
