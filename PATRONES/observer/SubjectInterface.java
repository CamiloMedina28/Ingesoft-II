package PATRONES.observer;

public interface SubjectInterface {
    void addObserver(ObserverInterface observer);

    void removeObserver(ObserverInterface observer);

    void notifyObservers();
}
