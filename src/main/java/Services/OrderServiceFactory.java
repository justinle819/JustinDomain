package Services;

public class OrderServiceFactory {
    private OrderServiceFactory() {}

    public static OrderService createOrderService(OrderConfig ...cfgs) {
        OrderService os = new OrderService();
        for(OrderConfig cfg: cfgs) {
            cfg.setOrderService(os);
        }
        return os;
    }
}
