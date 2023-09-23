package management.products;

import management.products.model.Order;
import management.products.model.Product;
import management.products.service.ProductService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> PRODUCTS = new ArrayList<>();
    public static List<Order> ORDERS = new ArrayList<>();

    public static void menu() {
        System.out.println("Danh sach chuc nang");
        System.out.println("1. Them moi san pham");
        System.out.println("2. Hien thi san pham");
        System.out.println("3. Sua san pham");
        System.out.println("4. Xoa san pham");
        System.out.println("5. Mua hang");
        System.out.println("6. Hien thi danh sach don hang");
        System.out.println("7. Thoat");
    }

    public static void main(String[] args) {
        ProductService productService = new ProductService();

        int option = 0;
        do {
            menu();

            try {
                // kiem tra da nhap dung chuc nang trong chuong trinh chua?
                do {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Vui long chon chuc nang can dung");
                    option = Integer.parseInt(sc.nextLine());
                    if(option < 1 || option > 7) {
                        System.out.println("Khong nhap dung chuc nang hien co, vui long nhap lai");
                    }
                } while(option < 1 || option > 7);

                switch(option) {
                    case 1:
                        productService.insert();
                        break;
                    case 2:
                        productService.show();
                        break;
                    case 3:
                        productService.update();
                        break;
                    case 4:
                        productService.delete();
                        break;
                }

                if(option == 7) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Nhap option khong dung kieu du lieu, vui long nhap so");
            } catch (Exception e) {
                System.out.println("He thong gap loi, vui long thu lai");
            }
        } while(true);
        System.out.println("Cam on ban da dung chuong trinh, hen gap lai!!");
    }
}