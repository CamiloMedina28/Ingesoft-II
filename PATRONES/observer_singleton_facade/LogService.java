package PATRONES.observer_singleton_facade;

public class LogService implements ObserverInterface{
    @Override
    public void Update(String message) {
        System.out.println("LOG SERVICE: " + message);
    }
}
