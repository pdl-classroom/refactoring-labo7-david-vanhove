package ch.heigvd.pdl.refactoring;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;

public class OrdersWriter {
    private final List<Order> orders;

    public OrdersWriter(List<Order> orders) { this.orders = orders; }

    public String getContents() {
        JSONObject jsonObject = new JSONObject();
        JSONArray ordersArray = new JSONArray();

        for (Order order : orders)
            ordersArray.put(order.toJSON());

        jsonObject.put("orders", ordersArray);
        return jsonObject.toString();
    }
}
