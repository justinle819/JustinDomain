package Repository;
import Aggregate.Product;
import Exception.OperationException;
import Services.OrderConfig;
import Services.OrderService;

import java.util.*;

public class MemoryProductRepository implements ProductRepository, OrderConfig {
    private Map<UUID, Product> products = new HashMap<>();

    @Override
    public List<Product> getALl() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getById(UUID id) throws OperationException {
        boolean found = products.containsKey(id);
        if(!found) {
            throw new OperationException("Product not found");
        }
        return products.get(id);
    }

    @Override
    public void add(Product product) throws OperationException {
        boolean found = products.containsKey(product.getId());
        if(found) {
            throw new OperationException("Product already exists");
        }
        products.put(product.getId(),product);
    }

    @Override
    public void update(Product product) throws OperationException {
        boolean found = products.containsKey(product.getId());
        if(!found) {
            throw new OperationException("product not found");
        }
        products.put(product.getId(),product);
    }

    @Override
    public void delete(UUID id) throws OperationException {
        boolean found = products.containsKey(id);
        if(!found) {
            throw new OperationException("product not found");
        }
        products.remove(id);
    }

    @Override
    public void setOrderService(OrderService os) {
        os.setProducts(this);
    }
}
