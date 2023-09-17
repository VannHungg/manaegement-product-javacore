package management.products.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
    private Customer customer;

    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Order() {
    }

    public Order(Integer id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
}
