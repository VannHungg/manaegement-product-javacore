package management.products.service;

import management.products.Main;
import management.products.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductService {

    public Product insertEachProduct() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap vao ten san pham");
        String name = sc.nextLine();

        System.out.println("Nhap vao ghi chu cua san pham");
        String note = sc.nextLine();

        System.out.println("Nhap vao gia san pham");
        Float price = Float.parseFloat(sc.nextLine());

        System.out.println("Nhap vao so luong san pham");
        Integer quantity = Integer.parseInt(sc.nextLine());

        return new Product(name, note, price, quantity);
    }

    public void insert() {
        try {
            Product product = insertEachProduct();
            Main.PRODUCTS.add(product);
        } catch (InputMismatchException e1) {
            System.out.println("Ban da nhap sai gia tri dau vao");
        } catch (Exception e1) {
            System.out.println("Da xay ra loi, moi ban nhap lai");
        }
    }

    public void update() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap vao ma san pham can cap nhat");
            Integer id = Integer.parseInt(sc.nextLine());

            // kiem tra xem id nhap vao co ton tai khong
            Product product = null;
            for (Product p :
                    Main.PRODUCTS) {
                if (p.getId().equals(id)) {
                    product = insertEachProduct();
                    Product.count--;
                    p.setName(product.getName());
                    p.setQuantity(product.getQuantity());
                    p.setNote(product.getNote());
                    p.setPrice(product.getPrice());
                    System.out.println("Update san pham thanh cong");
                    break;
                }
            }

            if (product == null) {
                System.out.println("Khong co san pham co ma la " + id);
            } else {
                System.out.println("Cap nhat san pham thanh cong");
            }
        } catch (InputMismatchException e1) {
            System.out.println("Ban da nhap sai gia tri dau vao");
        } catch (Exception e1) {
            System.out.println("Da xay ra loi, moi ban nhap lai");
        }
    }

    public void delete() {
        try {
            System.out.println("Nhap vao id san pham can xoa");
            Scanner sc = new Scanner(System.in);
            Integer id = Integer.parseInt(sc.nextLine());

            boolean bCheck = false;
            for (Product p : Main.PRODUCTS
                 ) {
                if(p.getId().equals(id)) {
                    Main.PRODUCTS.remove(p);
                    bCheck = true;
                    break;
                }
            }

            if(bCheck == true) {
                System.out.println("Xoa thanh cong san pham");
            } else {
                System.out.println("Xoa san pham khong thanh cong");
            }
        } catch (InputMismatchException e) {
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
            String row = String.format("%10d%30s%20s%20d%10f", p.getId(), p.getName(), p.getNote(), p.getQuantity(), p.getPrice());
            System.out.println(row);
        }
    }
}
