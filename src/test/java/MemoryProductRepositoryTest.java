import Aggregate.Product;
import Aggregate.ProductFactory;
import Repository.MemoryProductRepository;
import org.junit.jupiter.api.Test;
import Exception.*;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryProductRepositoryTest {

    @Test
    void testGetProductToRepo() throws ProductInputException, OperationException{
        Product product = ProductFactory.createProduct("shampoo","Cleaning stuff",9.91);
        MemoryProductRepository repo = new MemoryProductRepository();
        repo.add(product);
        Product expected = repo.getById(product.getId());
        assertEquals(expected,product);
    }

    @Test
    void testAddProductToRepo() throws ProductInputException, OperationException {
        Product product = ProductFactory.createProduct("shampoo","Cleaning stuff",9.91);
        MemoryProductRepository repo = new MemoryProductRepository();
        repo.add(product);
        Product found = repo.getById(product.getId());
        assertNotNull(found);
    }

    @Test
    void testDeleteProductFromRepo() throws ProductInputException, OperationException {
        Product product = ProductFactory.createProduct("shampoo","Cleaning stuff",9.91);
        MemoryProductRepository repo = new MemoryProductRepository();
        repo.add(product);
        Product found = repo.getById(product.getId());
        assertNotNull(found);
        repo.delete(product.getId());
        Exception exception = assertThrows(OperationException.class, () -> {
            Product foundAfterDelete = repo.getById(product.getId());
        });
        String expectedMessage = "Product not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
