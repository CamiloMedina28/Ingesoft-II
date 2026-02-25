package Solid.SRP.CorrectImplementation;

public class Main {
    public static void main(String[] args) {

        Factura factura = new Factura(new double[]{100, 200, 300});

        FacturaRepository repository = new FacturaRepository();
        EmailService emailService = new EmailService();

        double total = factura.calcularTotal();
        System.out.println("Total: " + total);

        repository.guardar(factura);
        emailService.enviarFactura(factura);
    }
}
