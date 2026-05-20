package PATRONES.observer_singleton;


public class Main {
    public static void main(String[] args){
        NotificationManager gestor = NotificationManager.getInstance();

        ObserverInterface emailService = new EmailService();
        ObserverInterface logservice = new LogService();

        gestor.addObserver(emailService);
        gestor.addObserver(logservice);

        gestor.sendNotification("Servidor inicializado.");
    }
}
