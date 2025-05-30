package ss17_banary_file.bai_tap.product_management.service;

import ss17_banary_file.bai_tap.product_management.modle.Product;
import ss17_banary_file.bai_tap.product_management.repository.IProductRepository;
import ss17_banary_file.bai_tap.product_management.repository.ProductRepository;


import java.util.List;

public class ServiceProduct implements IProductService{
    IProductRepository iRepository = new ProductRepository();
    @Override
    public List<Product> seachByName(String name) {
        return iRepository.seachByName(name);
    }
    @Override
    public void add(Object o) throws ClassNotFoundException {
    }
    @Override
    public List<Product> getAll() throws ClassNotFoundException {
        return iRepository.getAll();
    }

    @Override
    public List<Product> displayProducts() {
        return null;
    }

    @Override
    public Product finByCode(int code) throws ClassNotFoundException {
        return iRepository.finByCode(code);
    }
}



}
