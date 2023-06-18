package ch.heigvd.pdl.refactoring;

public class Product {
    private final String code;
    private final Color color;
    private final Size size;
    private final double price;
    private final String currency;

    public Product(String code, Color color, Size size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public String getColor() {
        return color.toString();
    }

    public String getSize() { return size.toString(); }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}