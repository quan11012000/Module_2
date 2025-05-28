package ss12_java_collection_framework.mvc.repository;

import ss12_java_collection_framework.mvc.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository implements IProductRepository {
    private List<Product> products = new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return products;
    }
    @Override
    public void edit(Product product) {

    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }
    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> sortByPrice(boolean ascending) {
        List<Product> sortedList = new ArrayList<>(products);
        if (ascending){
             sortedList.sort(Comparator.comparing(Product::getPrice).thenComparing(Product::getId));
        }else {
             sortedList.sort(Comparator.comparing(Product::getPrice).thenComparing(Product::getId).reversed());
        }
        return sortedList;
    }

    @Override
    public List<Product> sortByName(boolean ascending) {
        List<Product> sortedList = new ArrayList<>(products);
        if (ascending){
            sortedList.sort(Comparator.comparing(Product::getName).thenComparing(Product::getId));
        }else {
            sortedList.sort(Comparator.comparing(Product::getName).thenComparing(Product::getId).reversed());
        }
        return sortedList;
    }
}