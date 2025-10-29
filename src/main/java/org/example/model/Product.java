package org.example.model;
import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    public static int productCount = 1;

    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("Product{id=%s, name='%s', price=%.2f, quantity=%d}", id, name, price, quantity);
    }
}
