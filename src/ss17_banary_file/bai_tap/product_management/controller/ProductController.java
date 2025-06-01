package ss17_banary_file.bai_tap.product_management.controller;
import ss17_banary_file.bai_tap.product_management.modle.Product;
import ss17_banary_file.bai_tap.product_management.service.IProductService;
import ss17_banary_file.bai_tap.product_management.service.ProductService;
import ss17_banary_file.bai_tap.product_management.view.ProductView;
import java.util.List;
import java.util.stream.Collectors;
public class ProductController {
    private final IProductService productService = new ProductService();
    private final ProductView productView = new ProductView();

    public void start() throws ClassNotFoundException {
        while (true) {
            productView.displayMenu();
            int choice = productView.inputChoice();
            switch (choice) {
                case 1:
                    // Lấy danh sách mã code hiện có để kiểm tra trùng
                    List<Product> products = productService.getAll();
                    List<String> existingCodes = products.stream()
                            .map(Product::getCode)
                            .collect(Collectors.toList());

                    Product product = productView.inputProduct(existingCodes);

                    productService.add(product);
                    productView.showMessage("Thêm sản phẩm thành công!");
                    break;
                case 2:
                    List<Product> list = productService.getAll();
                    productView.displayProducts(list);
                    break;
                case 3:
                    String code = productView.inputId("tìm kiếm");
                    Product found = productService.findByCode(code);
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
