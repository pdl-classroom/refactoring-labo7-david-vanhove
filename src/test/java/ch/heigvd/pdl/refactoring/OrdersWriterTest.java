package ch.heigvd.pdl.refactoring;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class OrdersWriterTest {
    ArrayList<Order> orders = new ArrayList<>();
    Order order111 = new Order(111);

    @BeforeEach
    public void SetupOneOrder() {
        orders.add(order111);
    }

    private void assertJsonEquals(String expected, String actual) {
        assertEquals(new JSONObject(expected).toString(), new JSONObject(actual).toString());
    }

    @Test
    public void NoOrder() {
        assertJsonEquals("{\"orders\": []}", new OrdersWriter(new ArrayList<>()).getContents());
    }

    @Test
    public void OneOrder() {
        String expected = "{\"orders\": [{\"id\": 111, \"products\": []}]}";
        assertJsonEquals(expected, new OrdersWriter(orders).getContents());
    }

    @Test
    public void TwoOrders() {
        orders.add(new Order(222));
        String expected = "{\"orders\": [{\"id\": 111, \"products\": []}, {\"id\": 222, \"products\": []}]}";
        assertJsonEquals(expected, new OrdersWriter(orders).getContents());
    }

    @Test
    public void OneOrderWithOneProduct() {
        order111.AddProduct(new Product("Shirt", 1, 3, 2.99, "TWD"));
        String expected = "{\"orders\": [{\"id\": 111, \"products\": [{\"code\": \"Shirt\", \"color\": \"blue\", \"size\": \"M\", \"price\": 2.99, \"currency\": \"TWD\"}]}]}";
        assertJsonEquals(expected, new OrdersWriter(orders).getContents());
    }

    @Test
    public void OneOrderWithOneProductNoSize() {
        order111.AddProduct(new Product("Pot", 2, -1, 16.50, "SGD"));
        String expected = "{\"orders\": [{\"id\": 111, \"products\": [{\"code\": \"Pot\", \"color\": \"red\", \"price\": 16.5, \"currency\": \"SGD\"}]}]}";
        assertJsonEquals(expected, new OrdersWriter(orders).getContents());
    }
}
