package Services;

import Exception.*;
import java.util.List;
import java.util.UUID;

// Tavern is service that hold other sub services
public class Tavern {
    private OrderService os;

    public void order(UUID customerId, List<UUID> productIds) throws OperationException {
        double price = os.createOrder(customerId,productIds);
        System.out.printf("Bill the customer $%.2f%n", price);
    }

    public void setOs(OrderService os) {
        this.os = os;
    }
}
