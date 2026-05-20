package PATRONES.observer_singleton;

public class SMSService implements ObserverInterface{
    @Override
    public void update(String message){
        System.out.println("SMS: " + message);
    }
}