package management.products.service;

import management.products.Main;
import management.products.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductService {

    public void insert() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Nhap vao ten san pham");
            String name = sc.nextLine();

            System.out.println("Nhap vao ghi chu cua san pham");
            String note = sc.nextLine();

            System.out.println("Nhap vao gia san pham");
            Float price = Float.parseFloat(sc.nextLine());

            System.out.println("Nhap vao so luong san pham");
            Integer quantity = Integer.parseInt(sc.nextLine());

            Product product = new Product(name, note, price, quantity);
            Main.PRODUCTS.add(product);
        } catch (InputMismatchException e1) {
            System.out.println("Ban da nhap sai gia tri dau vao");
        } catch (Exception e1) {
            System.out.println("Da xay ra loi, moi ban nhap lai");
        }
    }

    public void show() {
        String header = String.format("%10s%30s%20s%20s%10s", "ID", "Name", "Note", "Quantity", "Price");
        System.out.println(header);
        for (Product p : Main.PRODUCTS
             ) {
            String row= String.format("%10d%30s%20s%20d%10f", p.getId(), p.getName(), p.getNote(), p.getQuantity(), p.getPrice());
            System.out.println(row);
        }
    }
}
