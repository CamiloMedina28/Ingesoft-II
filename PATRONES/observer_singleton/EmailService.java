package PATRONES.observer_singleton;

public class EmailService implements ObserverInterface {

    @Override
    public void update(String message) {
        System.out.println("Email: " + message);
    }
}