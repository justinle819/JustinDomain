package Aggregate;

import Entity.Item;
import java.util.UUID;

public class Product {
    // item here is an aggregate root
    private Item item;
    private double price;
    private int quantity;

    public Product(Item item, double price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getId() {
        return item.getId();
    }

    public double getPrice() {
        return price;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
