package PATRONES.observer_singleton_facade;

public interface SubjectInterface {
    void addObserver(ObserverInterface observer);

    void removeObserver(ObserverInterface observer);

    void notifyObservers();
}
