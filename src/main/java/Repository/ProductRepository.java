package Repository;
import Aggregate.Product;
import Exception.OperationException;
import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    public List<Product> getALl();
    public Product getById(UUID id) throws OperationException;
    public void add(Product product) throws OperationException;
    public void update(Product product) throws OperationException;
    public void delete(UUID id) throws OperationException;
}
