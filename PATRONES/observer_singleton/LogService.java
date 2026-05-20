package PATRONES.observer_singleton;

public class LogService implements ObserverInterface{

    @Override
    public void update(String message){
        System.out.println("LOG: " + message);
    }
}
