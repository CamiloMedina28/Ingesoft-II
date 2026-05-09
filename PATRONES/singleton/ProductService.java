package PATRONES.singleton;

class ProductService {

    private LoggerSingleton logger;

    // Dependency Injection
    public ProductService(LoggerSingleton logger) {
        this.logger = logger;
    }

    public void createProduct(String product) {
        logger.log("Product created: " + product);
    }
}