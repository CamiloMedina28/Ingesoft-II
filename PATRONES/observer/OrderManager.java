package PATRONES.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderManager implements SubjectInterface{

    private List<ObserverInterface> observers = new ArrayList<>();

    private String currentOrder;

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
            observer.update(currentOrder);
        }
    }

    public void createOrder(String order) {
        System.out.println("Nuevo pedido creado: " + order);
        this.currentOrder = order;
        notifyObservers();
    }
}
