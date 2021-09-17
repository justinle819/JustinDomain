package Repository;

import Aggregate.Customer;
import Exception.OperationException;
import Services.OrderConfig;
import Services.OrderService;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MemoryCustomerRepository implements CustomerRepository, OrderConfig {
    private Map<UUID,Customer> customers = new HashMap<>();

    @Override
    public Customer get(UUID id) throws OperationException {
        boolean found = customers.containsKey(id);
        if(!found) {
            throw new OperationException("Customer not found");
        }
        return customers.get(id);
    }

    @Override
    public void add(Customer customer) throws OperationException {
        boolean found = customers.containsKey(customer.getId());
        if(found) {
            throw new OperationException("Customer already exists");
        }
        customers.put(customer.getId(),customer);
    }

    @Override
    public void update(Customer customer) throws OperationException {
        boolean found = customers.containsKey(customer.getId());
        if(!found) {
            throw new OperationException("Customer not found");
        }
        customers.put(customer.getId(),customer);
    }

    @Override
    public void setOrderService(OrderService os) {
        os.setCustomers(this);
    }
}
