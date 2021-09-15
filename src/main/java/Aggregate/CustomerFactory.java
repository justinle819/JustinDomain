package Aggregate;
import Entity.Item;
import Entity.Person;
import Exception.CustomerInputException;
import ValueObject.Transaction;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class CustomerFactory {
    private CustomerFactory() {}

    public static Customer createCustomer(String name, int age) throws CustomerInputException {
        if(name == "" || age == 0) {
            throw new CustomerInputException("Invalid Input");
        }
        Person person = new Person(UUID.randomUUID(),name,age);
        List<Item> products = new LinkedList();
        List<Transaction> transactions = new LinkedList();
        Customer customer = new Customer(person,products,transactions);
        return customer;
    }

}
