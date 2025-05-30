package ss17_banary_file.bai_tap.product_management.service;

import ss17_banary_file.bai_tap.product_management.modle.Product;

import java.util.List;

public interface IProductService extends Iservice{
    List<Product> seachByName(String name) ;
}
