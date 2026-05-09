package PATRONES.singleton;

class OrderService {

    private LoggerSingleton logger;

    // Dependency Injection
    public OrderService(LoggerSingleton logger) {
        this.logger = logger;
    }

    public void createOrder(String orderId) {
        logger.log("Order created: " + orderId);
    }
}