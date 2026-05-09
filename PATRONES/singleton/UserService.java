package PATRONES.singleton;

class UserService {

    private LoggerSingleton logger;

    // Dependency Injection
    public UserService(LoggerSingleton logger) {
        this.logger = logger;
    }

    public void createUser(String username) {
        logger.log("User created: " + username);
    }
}