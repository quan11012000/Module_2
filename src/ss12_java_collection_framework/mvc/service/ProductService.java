package ss12_java_collection_framework.mvc.service;

import ss12_java_collection_framework.mvc.model.Product;
import ss12_java_collection_framework.mvc.repository.ProductRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements IProductService {
    private ProductRepository repository = new ProductRepository();

    @Override
    public List<Product> sortByPrice(boolean ascending) {
        return repository.sortByPrice(ascending);
    }

    @Override
    public List<Product> sortByName(boolean ascending) {
        return repository.sortByName(ascending);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void edit(Product product) {
        repository.edit(product);
    }

    @Override
    public void add(Product product) {
        if(findById(product.getId())!=null){
            System.out.println("id ton tai");
        }else{
            repository.add(product);
        }
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}