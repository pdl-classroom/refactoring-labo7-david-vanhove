package ch.heigvd.pdl.refactoring;

public class Product {

    public static final int SIZE_NOT_APPLICABLE = -1;

    private String code;
    private int color;
    private int size;
    private double price;
    private String currency;

    public Product(String code, int color, int size, double price, String currency) {
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
        return Color.getColor(color);
    }

    public String getSize() {
        if(size != SIZE_NOT_APPLICABLE) {
            return Size.getSize(size);
        }
        return null;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}