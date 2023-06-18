package ch.heigvd.pdl.refactoring;

import java.util.Objects;

public class Product {
    private final String code;
    private final Color color;
    private final Size size;
    private final double price;
    private final String currency;

    public Product(String code, Color color, Size size, double price, String currency) {
        if (code == null) {
            throw new IllegalArgumentException("Code cannot be null");
        }
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        if (currency == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() { return code; }

    public String getColor() { return color.toString(); }

    public String getSize() { return size.toString(); }

    public double getPrice() { return price; }

    public String getCurrency() { return currency; }
}