package Repository;
import Aggregate.Customer;
import Exception.OperationException;

import java.util.UUID;

public interface CustomerRepository {
    public Customer get(UUID id) throws OperationException;
    public void add(Customer customer) throws OperationException;
    public void update(Customer customer) throws OperationException;
}
