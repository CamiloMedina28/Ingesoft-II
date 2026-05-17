package PATRONES.observer;


public class Main {
    public static void main(String[] args){
        OrderManager gestor = new OrderManager();

        ObserverInterface emailService = new EmailService();
        ObserverInterface smsservice = new SMSService();
        ObserverInterface analyticsservice = new AnalyticsService();

        gestor.addObserver(emailService);
        gestor.addObserver(smsservice);
        gestor.addObserver(analyticsservice);

        gestor.createOrder("Pedido #1");
        gestor.createOrder("Pedido #2");

    }
}
