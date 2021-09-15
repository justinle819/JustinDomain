import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import Aggregate.Customer;
import Aggregate.CustomerFactory;
import org.junit.jupiter.api.Test;
import Exception.CustomerInputException;

public class CustomerFactoryTest {

    @Test
    void testCreateCustomerWithInvalidName() throws CustomerInputException {
        Exception exception = assertThrows(CustomerInputException.class, () -> {
            Customer customer = CustomerFactory.createCustomer("",10);
        });
        String expectedMessage = "Invalid Input";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateCustomerWithInvalidAge() throws CustomerInputException {
        Exception exception = assertThrows(CustomerInputException.class, () -> {
            Customer customer = CustomerFactory.createCustomer("Justin",0);
        });
        String expectedMessage = "Invalid Input";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
