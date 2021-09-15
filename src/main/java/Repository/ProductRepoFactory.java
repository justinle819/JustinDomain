package Repository;
import Aggregate.Product;
import Exception.OperationException;
import java.util.List;

public class ProductRepoFactory {
    private ProductRepoFactory() {}

    public static ProductRepository createMemoryProductRepo(List<Product> products) throws OperationException {
        ProductRepository prodMemory = new MemoryProductRepository();
        for(Product p : products) {
            prodMemory.add(p);
        }
        return prodMemory;
    }
}
