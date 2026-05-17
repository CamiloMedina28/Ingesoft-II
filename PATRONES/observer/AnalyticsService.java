package PATRONES.observer;

public class AnalyticsService implements ObserverInterface{

    @Override
    public void update(String order){
        System.out.println("Actualizando el servicio de analítica de datos con la orden: " + order);
    }
}
