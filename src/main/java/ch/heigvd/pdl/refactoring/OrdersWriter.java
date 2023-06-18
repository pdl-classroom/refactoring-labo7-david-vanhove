package ch.heigvd.pdl.refactoring;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;

public class OrdersWriter {
    private final List<Order> orders;

    public OrdersWriter(List<Order> orders) {
        this.orders = orders;
    }

    public String getContents() {
        JSONObject jsonObject = new JSONObject();
        JSONArray ordersArray = new JSONArray();

        for (Order order : orders)
            ordersArray.put(createOrderObject(order));

        jsonObject.put("orders", ordersArray);
        return jsonObject.toString();
    }

    private JSONObject createOrderObject(Order order) {
        JSONObject orderObject = new JSONObject();
        JSONArray productsArray = new JSONArray();

        for (Product product : order.getProducts())
            productsArray.put(createProductObject(product));

        orderObject.put("id", order.getOrderId());
        orderObject.put("products", productsArray);

        return orderObject;
    }

    private JSONObject createProductObject(Product product) {
        JSONObject productObject = new JSONObject();

        productObject.put("code", product.getCode());
        productObject.put("color", product.getColor());

        if (!product.getSize().equals(Size.NOT_APPLICABLE.toString())) {
            productObject.put("size", product.getSize());
        }

        productObject.put("price", product.getPrice());
        productObject.put("currency", product.getCurrency());

        return productObject;
    }
}
