package ch.heigvd.pdl.refactoring;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<Product> products = new ArrayList<>();
    private final int id;

    public Order(int id) { this.id = id; }

    public int getOrderId() { return id; }

    public List<Product> getProducts() { return Collections.unmodifiableList(products); }

    public void addProduct(Product product) { products.add(product); }

    public JSONObject toJSON() {
        JSONObject orderObject = new JSONObject();
        JSONArray productsArray = new JSONArray();

        for (Product product : this.getProducts())
            productsArray.put(product.toJSON());

        orderObject.put("id", this.getOrderId());
        orderObject.put("products", productsArray);

        return orderObject;
    }
}
