package PATRONES.observer_singleton_facade;

public class Main {
     public static void main(String[] args) {

        NotificationManager manager =
                NotificationManager.getInstance();

        manager.addObserver(
                new EmailService());

        manager.addObserver(
                new LogService());

        OrderFacade facade =
                new OrderFacade();

        facade.createOrder(
                "Pedido #1001",
                "Camilo Medina");
    }
}
