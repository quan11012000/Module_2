package ss17_banary_file.bai_tap.product_management.modle;

public class Product {
    private int code;
    private String name;
    private float price;
    private String item;
    private String description;
    public Product(){

    }

    public Product(int code, String name, float price, String item, String description) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.item = item;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString(){
        return "Mã SP: " + code + ", Tên: " + name + ", Giá: " + price
                + ", Hãng: " + item + ", Mô tả: " + description;
    }
}
