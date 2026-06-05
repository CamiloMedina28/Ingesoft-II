package PATRONES.observer_singleton_facade;

public class OrderFacade {
    
    private LoggerSingleton logger;

    private NotificationManager notificationManager;

    public OrderFacade() {

        logger = LoggerSingleton.getInstance();

        notificationManager =
                NotificationManager.getInstance();
    }

    public void createOrder(
            String orderName,
            String clientName) {

        Factura factura = new Factura.Builder()
                .numero(1)
                .cliente(clientName)
                .metodoPago("Tarjeta")
                .build();

        logger.addLog(
                "Factura creada: " + factura);

        notificationManager.sendNotification(
                "Pedido registrado: " + orderName);

        System.out.println(
                "Proceso completado correctamente");
    }
}
