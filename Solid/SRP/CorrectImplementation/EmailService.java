package Solid.SRP.CorrectImplementation;

class EmailService {

    public void enviarFactura(Factura factura) {

        double total = factura.calcularTotal();

        String asunto = "Factura generada";
        String cuerpo = "Estimado cliente,\n\n"
                + "El total de su factura es: $" + total + "\n\n"
                + "Gracias por su compra.";


        System.out.println("Enviando correo...");
        System.out.println("Asunto: " + asunto);
        System.out.println("Contenido:\n" + cuerpo);
        System.out.println("Correo enviado correctamente.");
    }
}