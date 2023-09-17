package management.products.model;

import management.products.Main;

public class Product {
    private static int count = Main.PRODUCTS.size();
    private Integer id;
    private String name;
    private String note;
    private Float price;
    private Integer quantity;

    public Product(String name, String note, Float price, Integer quantity) {
        this.id = ++count;
        this.name = name;
        this.note = note;
        this.price = price;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
