import Aggregate.Product;
import Aggregate.ProductFactory;
import Exception.*;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static List<Product> initProducts() throws ProductInputException {
        Product beer = ProductFactory.createProduct("Beer","Healthy Beverage",2.00);
        Product wine = ProductFactory.createProduct("Beer","Healthy Snack",1.00);
        Product peanuts = ProductFactory.createProduct("Peanuts","Healthy Snack",1.50);
        List<Product> products = new ArrayList<>();
        products.add(beer);
        products.add(wine);
        products.add(peanuts);
        return products;
    }

}
