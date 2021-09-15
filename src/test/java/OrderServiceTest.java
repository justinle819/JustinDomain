import Aggregate.Customer;
import Aggregate.CustomerFactory;
import Aggregate.Product;
import Repository.*;
import Services.OrderConfig;
import Services.OrderService;
import Services.OrderServiceFactory;
import org.junit.jupiter.api.Test;
import Exception.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void testNewOrderService() throws ProductInputException, OperationException, CustomerInputException {
        List<Product> products = TestUtil.initProducts();
        ProductRepository memProductRepo = ProductRepoFactory.createMemoryProductRepo(products);
        CustomerRepository memCustomerRepo = CustomerRepoFactory.createMemoryProductRepo();
        Customer customer = CustomerFactory.createCustomer("Percy",21);
        memCustomerRepo.add(customer);
        OrderService os = OrderServiceFactory.createOrderService((OrderConfig) memProductRepo,(OrderConfig)memCustomerRepo);
        // we can replace the memory repos with mongo repos which implements the same interface
        List<UUID> productIdsForOrdering = new ArrayList<>();
        productIdsForOrdering.add(products.get(0).getId());
        productIdsForOrdering.add(products.get(0).getId());
        double actualPrice = os.createOrder(customer.getId(),productIdsForOrdering);
        double expectedPrice = 4.00;
        assertEquals(actualPrice,expectedPrice);
    }
}
