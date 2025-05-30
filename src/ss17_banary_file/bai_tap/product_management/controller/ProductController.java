package ss17_banary_file.bai_tap.product_management.controller;

import ss17_banary_file.bai_tap.product_management.modle.Product;
import ss17_banary_file.bai_tap.product_management.service.IProductService;
import ss17_banary_file.bai_tap.product_management.service.ProductService;
import ss17_banary_file.bai_tap.product_management.view.ProductView;

import java.util.List;

public class ProductController {
    private final IProductService productService = new ProductService();
    private final ProductView productView = new ProductView();

    public void start() throws ClassNotFoundException {
        while (true) {
            productView.displayMenu();
            int choice = productView.inputChoice();
            switch (choice) {
                case 1:
                    Product product = productView.inputProduct();
                    if (productService.findByCode(product.getCode()) != null) {
                        productView.showMessage("Mã sản phẩm đã tồn tại, không thể thêm.");
                    } else if (product.getPrice() < 0) {
                        productView.showMessage("Giá sản phẩm không hợp lệ.");
                    } else {
                        productService.add(product);
                        productView.showMessage("Thêm sản phẩm thành công!");
                    }
                    break;
                case 2:
                    List<Product> products = productService.getAll();
                    productView.displayProducts(products);
                    break;
                case 3:
                    String code = productView.inputId("tìm kiếm");
                    Product found = (Product) productService.findByCode(code);
                    if (found == null) {
                        productView.showMessage("Không tìm thấy sản phẩm với mã: " + code);
                    } else {
                        productView.displayProduct(found);
                    }
                    break;
                case 0:
                    productView.showMessage("Thoát chương trình.");
                    return;
                default:
                    productView.showMessage("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }
}
