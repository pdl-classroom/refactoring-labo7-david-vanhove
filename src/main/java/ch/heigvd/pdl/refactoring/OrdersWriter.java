package ch.heigvd.pdl.refactoring;

import org.json.JSONArray;
import org.json.JSONObject;

public class OrdersWriter {
    private final Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        JSONObject jsonObject = new JSONObject();
        JSONArray ordersArray = new JSONArray();

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            ordersArray.put(createOrderObject(orders.getOrder(i)));
        }

        jsonObject.put("orders", ordersArray);
        return jsonObject.toString();
    }

    private JSONObject createOrderObject(Order order) {
        JSONObject orderObject = new JSONObject();
        JSONArray productsArray = new JSONArray();

        for (Product product : order.getProducts()) {
            productsArray.put(createProductObject(product));
        }

        orderObject.put("id", order.getOrderId());
        orderObject.put("products", productsArray);

        return orderObject;
    }

    private JSONObject createProductObject(Product product) {
        JSONObject productObject = new JSONObject();

        productObject.put("code", product.getCode());
        productObject.put("color", product.getColor());

        if (product.getSize() != null) {
            productObject.put("size", product.getSize());
        }

        productObject.put("price", product.getPrice());
        productObject.put("currency", product.getCurrency());

        return productObject;
    }
}
