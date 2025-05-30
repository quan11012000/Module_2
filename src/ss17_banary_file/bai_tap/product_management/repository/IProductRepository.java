package ss17_banary_file.bai_tap.product_management.repository;

import ss17_banary_file.bai_tap.product_management.modle.Product;

import java.util.List;

public interface IProductRepository extends Irepository<Product>{
    List<Product> seachByName(String name);

}
