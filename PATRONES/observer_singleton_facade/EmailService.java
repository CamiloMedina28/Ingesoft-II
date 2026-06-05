package PATRONES.observer_singleton_facade;

public class EmailService implements ObserverInterface{
    @Override
    public void Update(String message){
        System.out.println("EMAIL: " + message);
    }
}
