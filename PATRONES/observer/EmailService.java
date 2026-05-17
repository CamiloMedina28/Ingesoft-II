package PATRONES.observer;

public class EmailService implements ObserverInterface {

    @Override
    public void update(String order) {
        System.out.println("Email enviado del pedido: " + order);
    }
}