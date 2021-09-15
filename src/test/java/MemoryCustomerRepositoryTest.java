import Aggregate.Customer;
import Aggregate.CustomerFactory;
import Repository.MemoryCustomerRepository;
import org.junit.jupiter.api.Test;
import Exception.*;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryCustomerRepositoryTest {

    @Test
    void testGetCustomerToRepo() throws CustomerInputException, OperationException {
        Customer customer = CustomerFactory.createCustomer("Justin",10);
        MemoryCustomerRepository repo = new MemoryCustomerRepository();
        repo.add(customer);
        Customer expected = repo.get(customer.getId());
        assertEquals(expected,customer);
    }

    @Test
    void testAddCustomerToRepo() throws CustomerInputException, OperationException {
        Customer customer = CustomerFactory.createCustomer("Justin",10);
        MemoryCustomerRepository repo = new MemoryCustomerRepository();
        repo.add(customer);
        Customer found = repo.get(customer.getId());
        assertNotNull(found);
    }

}


