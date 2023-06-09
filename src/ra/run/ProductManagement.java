package ra.run;

import custom.utils.InputMethods;
import ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    private static List productList = new ArrayList();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần\n" +
                    "4. Xóa sản phẩm theo mã sản phẩm\n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm\n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm\n" +
                    "7. Thoát\n");

            System.out.print("Nhập một lựa chọn: ");
            byte option = InputMethods.getByte();
            switch (option) {
                case 1:
                    inputProductsList();
                    break;
                case 2:
                    displayProductsListInfo();
                    break;
                case 3:
                    sortByInterest();
                    break;
                case 4:
                    deleteProductById();
                    break;
                case 5:
                    findProductByName();
                    break;
                case 6:
                    changeProductStatus();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ! Vui lòng thử lại...");
            }
            System.out.println("Nhấn phím bất kỳ để tiếp tục...");
            InputMethods.pressAnyKey();
        }
    }

    private static void changeProductStatus() {
        if (isEmpty()) return;
        int index = findProductById();
        if (index < 0) {
            System.out.println("Không tìm thấy giá trị hợp lệ");
            return;
        }
        Product product = (Product) productList.get(index);
        boolean status = product.isProductStatus() ? false : true;
        System.out.println("Thay đổi trạng thái sản phẩm thành công");
        product.setProductStatus(status);
    }

    private static void findProductByName() {
        if (isEmpty()) return;
        System.out.print("Nhập tên sản phẩm: ");
        String productName = InputMethods.getString();
        for (int i = 0; i < productList.size(); i++) {
            Product product = (Product) productList.get(i);
            if (product.getProductName().equals(productName)) {
                product.displayData();
            } else if (i == productList.size() - 1) {
                System.out.println("Không tìm thấy giá trị hợp lệ");
            }
        }
    }

    private static void deleteProductById() {
        if (isEmpty()) return;
        int index = findProductById();
        if (index < 0) {
            System.out.println("Không tìm thấy giá trị hợp lệ");
            return;
        }
        System.out.println("Xoá sản phẩm thành công");
        productList.remove(index);
    }

    private static int findProductById() {
        System.out.print("Nhập mã sản phẩm: ");
        int id = InputMethods.getInteger();
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            Product product = (Product) productList.get(i);
            if (product.getProductId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void sortByInterest() {
        if (isEmpty()) return;
        Collections.sort(productList);
        System.out.println("Sắp xếp thành công!!!!");
//        displayProductsListInfo();
    }

    private static void displayProductsListInfo() {
        if (isEmpty()) return;
        for (int i = 0; i < productList.size(); i++) {
            Product product = (Product) productList.get(i);
            product.displayData();
        }
    }

    private static void inputProductsList() {
        System.out.print("Nhập số sản phẩm trong danh sách ");
        int size = InputMethods.getInteger();
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1));
            Product product = new Product();
            product.inputData();
            productList.add(product);
        }
    }

    private static boolean isEmpty() {
        if (productList.size() == 0) {
            System.err.println("Danh sách đang trống, vui lòng chọn lựa chọn ...");
            return true;
        }
        return false;
    }

    private static int getSize() {
        return productList.size();
    }
}
