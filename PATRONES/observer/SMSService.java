package PATRONES.observer;

public class SMSService implements ObserverInterface{
    @Override
    public void update(String order){
        System.out.println("Enviando mensaje de texto de la orden: " + order);
    }
}