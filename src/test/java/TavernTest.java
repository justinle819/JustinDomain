import Aggregate.Customer;
import Aggregate.CustomerFactory;
import Aggregate.Product;
import Repository.*;
import Services.*;
import org.junit.jupiter.api.Test;
import Exception.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TavernTest {

    @Test
    void testTavern() throws ProductInputException, OperationException, CustomerInputException {
        List<Product> products = TestUtil.initProducts();
        ProductRepository memProductRepo = ProductRepoFactory.createMemoryProductRepo(products);
        CustomerRepository memCustomerRepo = CustomerRepoFactory.createMemoryProductRepo();
        Customer customer = CustomerFactory.createCustomer("Percy",21);
        memCustomerRepo.add(customer);
        // the reason for casting because both ProductRepository and OrderConfig are interfaces. Two interface which one might not have method of the others
        OrderService os = OrderServiceFactory.createOrderService((OrderConfig) memProductRepo,(OrderConfig)memCustomerRepo);
        // OrderService is a concrete class and implements all of OrderConfig methods, therefore no need for casting
        Tavern tavern = TavernFactory.createTavernService(os);
        List<UUID> productIdsForOrdering = new ArrayList<>();
        productIdsForOrdering.add(products.get(0).getId());
        productIdsForOrdering.add(products.get(0).getId());
        tavern.order(customer.getId(),productIdsForOrdering);
    }
}
