package ss12_java_collection_framework.mvc.service;


import ss12_java_collection_framework.mvc.model.Product;

import java.util.List;

public interface IProductService extends IService<Product> {
    List<Product> sortByPrice(boolean ascending);
    List<Product> sortByName(boolean ascending);
}
