package Services;

import Aggregate.Customer;
import Aggregate.Product;
import Repository.CustomerRepository;
import Repository.ProductRepository;
import Exception.OperationException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService implements TavernConfig {
    private CustomerRepository customers;
    private ProductRepository products;

    public OrderService() {}

    public double createOrder(UUID customerId, List<UUID> productIds) throws OperationException {
        double price = 0.0;
        List<Product> products = new ArrayList<>();
        Customer customer = customers.get(customerId);
        for(UUID productId: productIds) {
            Product product = this.products.getById(productId);
            products.add(product);
            price += product.getPrice();
        }
        System.out.printf("Customer: %s has ordered %d products %n", customer.getId(),products.size());
        return price;
    }

    public void setCustomers(CustomerRepository customers) {
        this.customers = customers;
    }

    public void setProducts(ProductRepository products) {
        this.products = products;
    }

    @Override
    public void setTarvernService(Tavern t) {
        t.setOs(this);
    }
}
