package ra.bussinessImp;

import custom.utils.InputMethods;
import ra.bussiness.IProduct;
import ra.run.ProductManagement;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Product implements IProduct, Comparable<Product> {
    private int productId;
    private String productName, title, description;
    private float importPrice, exportPrice, interest;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String description, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
        setInterest();
    }

    public float getInterest() {
        return interest;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override

    public void inputData() {
        System.out.println("---------------------Start Input---------------------");
        System.out.print("Nhập ID sản phẩm: ");
        setProductId(InputMethods.getInteger());
        System.out.print("Nhập tên sản phẩm: ");
        setProductName(InputMethods.getString());
        System.out.print("Nhập tiêu đề sản phẩm: ");
        setTitle(InputMethods.getString());
        System.out.print("Nhập mô tả sản phẩm: ");
        setDescription(InputMethods.getString());
        System.out.print("Nhập giá nhập hàng: ");
        setImportPrice(InputMethods.getFloat());
        System.out.print("Nhập giá xuất hàng: ");
        setExportPrice(InputMethods.getFloat());
        System.out.print("Nhập trạng thái sản phẩm: ");
        setProductStatus(InputMethods.getBoolean());
        setInterest();
        System.out.println("---------------------End Input---------------------");
    }

    @Override
    public void displayData() {
        setInterest();
        System.out.println("-------------------------------Thông tin sản phẩm-------------------------------");
        System.out.printf("Id: %-20d" + "Tên sản phẩm: %-20s\n" +
                        "Tiêu đề: %-20s" + "Mô tả: %-20s\n" +
                        "Giá nhập: %-20.2f" + "Giá xuất: %-20.2f" + "Lợi nhuận: %-20.2f\n" +
                        "Trạng thái: %s\n",
                getProductId(), getProductName(),
                getTitle(), getDescription(),
                getImportPrice(), getExportPrice(), getInterest(),
                (isProductStatus() ? "Còn hàng" : "Hết hàng")
        );
        System.out.println("-------------------------------------------------------------------------------");
    }

    @Override
    public int compareTo(Product product) {
        return   (int) (this.getInterest() - product.getInterest());
    }
}
