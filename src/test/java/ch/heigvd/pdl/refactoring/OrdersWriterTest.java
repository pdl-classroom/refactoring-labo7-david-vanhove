package ch.heigvd.pdl.refactoring;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class OrdersWriterTest {
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
    void NoOrder() {
        assertJsonEquals("{\"orders\": []}", new OrdersWriter(new ArrayList<>()).getContents());
    }

    @Test
    void OneOrder() {
        String expected = "{\"orders\": [{\"id\": 111, \"products\": []}]}";
        assertJsonEquals(expected, new OrdersWriter(orders).getContents());
    }

    @Test
    void TwoOrders() {
        orders.add(new Order(222));
        String expected = "{\"orders\": [{\"id\": 111, \"products\": []}, {\"id\": 222, \"products\": []}]}";
        assertJsonEquals(expected, new OrdersWriter(orders).getContents());
    }

    @Test
    void OneOrderWithOneProduct() {
        order111.addProduct(new Product("Shirt", Color.BLUE, Size.M, 2.99, "TWD"));
        String expected = "{\"orders\": [{\"id\": 111, \"products\": [{\"code\": \"Shirt\", \"color\": \"blue\", \"size\": \"M\", \"price\": 2.99, \"currency\": \"TWD\"}]}]}";
        assertJsonEquals(expected, new OrdersWriter(orders).getContents());
    }

    @Test
    void OneOrderWithOneProductNoSize() {
        order111.addProduct(new Product("Pot", Color.RED, Size.NOT_APPLICABLE, 16.50, "SGD"));
        String expected = "{\"orders\": [{\"id\": 111, \"products\": [{\"code\": \"Pot\", \"color\": \"red\", \"price\": 16.5, \"currency\": \"SGD\"}]}]}";
        assertJsonEquals(expected, new OrdersWriter(orders).getContents());
    }

    @Test
    void EmptyOrder() {
        Order emptyOrder = new Order(112);
        orders.add(emptyOrder);
        String expected = "{\"orders\": [{\"id\": 111, \"products\": []}, {\"id\": 112, \"products\": []}]}";
        assertJsonEquals(expected, new OrdersWriter(orders).getContents());
    }

    @Test
    void OrderWithMultipleProducts() {
        order111.addProduct(new Product("Shirt", Color.BLUE, Size.M, 2.99, "TWD"));
        order111.addProduct(new Product("Pot", Color.RED, Size.NOT_APPLICABLE, 16.50, "SGD"));
        String expected = "{\"orders\": [{\"id\": 111, \"products\": [{\"code\": \"Shirt\", \"color\": \"blue\", \"size\": \"M\", \"price\": 2.99, \"currency\": \"TWD\"}, {\"code\": \"Pot\", \"color\": \"red\", \"price\": 16.5, \"currency\": \"SGD\"}]}]}";
        assertJsonEquals(expected, new OrdersWriter(orders).getContents());
    }

    @Test
    void ProductWithInvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> new Product(null, Color.BLUE, Size.M, 2.99, "TWD"));
        assertThrows(IllegalArgumentException.class, () -> new Product("Shirt", null, Size.M, 2.99, "TWD"));
        assertThrows(IllegalArgumentException.class, () -> new Product("Shirt", Color.BLUE, null, 2.99, "TWD"));
        assertThrows(IllegalArgumentException.class, () -> new Product("Shirt", Color.BLUE, Size.M, -2.99, "TWD"));
        assertThrows(IllegalArgumentException.class, () -> new Product("Shirt", Color.BLUE, Size.M, 2.99, null));
    }
}
