package PATRONES.observer_singleton;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager implements SubjectInterface{

    private static NotificationManager instance;
    private List<ObserverInterface> observers = new ArrayList<>();
    private String message;

    private NotificationManager() {}
     public static NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    @Override
    public void addObserver(ObserverInterface observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(ObserverInterface observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for (ObserverInterface observer: observers){
            observer.update(message);
        }
    }

    public void sendNotification(String message) {
        this.message = message;
        System.out.println("Nueva notificación: " + message);
        notifyObservers();
    }
}
