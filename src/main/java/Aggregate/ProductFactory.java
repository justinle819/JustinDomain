package Aggregate;

import Entity.Item;
import Entity.Person;
import ValueObject.Transaction;
import Exception.ProductInputException;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ProductFactory {

    private ProductFactory() {}

    public static Product createProduct(String name, String description, double price) throws ProductInputException {
        if(name == "" || description == "" || price == 0) {
            throw new ProductInputException("Invalid Product Input");
        }
        Product product = new Product(new Item(name,description),price,0);
        return product;
    }
}
