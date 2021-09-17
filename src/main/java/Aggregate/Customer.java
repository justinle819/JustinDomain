package Aggregate;

import Entity.Item;
import Entity.Person;
import ValueObject.Transaction;
import java.util.List;
import java.util.UUID;

public class Customer {
    // An aggregate is a cluster of associated objects that we treat as a unit for the purpose of data changes
    // person is a root aggregate. The only object that outside objects are allowed to hold reference to
    private Person person;
    private List<Item> products;
    private List<Transaction> transactions;

    public Customer(Person person, List<Item> products, List<Transaction> transactions) {
        this.person = person;
        this.products = products;
        this.transactions = transactions;
    }

    public UUID getId() {
        return person.getId();
    }

    public String getName() {
        return person.getName();
    }

}
