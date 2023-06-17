package ch.heigvd.pdl.refactoring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Order {
    private final List<Product> products = new ArrayList<>();
    private final int id;

    public Order(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return id;
    }

    public List<Product> getProducts() {
        return new LinkedList<>(products);
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }
}
