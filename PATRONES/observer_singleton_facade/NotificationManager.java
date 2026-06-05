package PATRONES.observer_singleton_facade;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager implements SubjectInterface{
    private static NotificationManager instance;

    private List<ObserverInterface> observers;

    private String message;

    private NotificationManager() {
        observers = new ArrayList<>();
    }

    public static synchronized NotificationManager getInstance() {

        if (instance == null) {
            instance = new NotificationManager();
        }

        return instance;
    }

    @Override
    public void addObserver(
            ObserverInterface observer) {

        observers.add(observer);
    }

    @Override
    public void removeObserver(
            ObserverInterface observer) {

        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (ObserverInterface observer : observers) {
            observer.Update(message);
        }
    }

    public void sendNotification(
            String message) {

        this.message = message;

        System.out.println(
                "Nueva notificación: " + message);

        notifyObservers();
    }
    
}
