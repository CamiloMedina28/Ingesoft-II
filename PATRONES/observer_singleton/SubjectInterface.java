package PATRONES.observer_singleton;

public interface SubjectInterface {
    void addObserver(ObserverInterface observer);

    void removeObserver(ObserverInterface observer);

    void notifyObservers();
}
