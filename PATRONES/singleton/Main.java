package PATRONES.singleton;

public class Main {

    public static void main(String[] args) {

        // Singleton instance
        LoggerSingleton logger = LoggerSingleton.getInstance();

        // Injecting dependency
        UserService userService = new UserService(logger);
        ProductService productService = new ProductService(logger);
        OrderService orderService = new OrderService(logger);

        userService.createUser("Camilo");
        productService.createProduct("Keyboard");
        orderService.createOrder("ORD-2026");

        logger.showLogs();
    }
}