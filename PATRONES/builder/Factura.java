package PATRONES.builder;

public class Factura {

    private String numero;
    private String cliente;
    private double subtotal;
    private double impuestos;
    private double descuento;
    private String metodoPago;

    private Factura(Builder builder) {
        this.numero = builder.numero;
        this.cliente = builder.cliente;
        this.subtotal = builder.subtotal;
        this.impuestos = builder.impuestos;
        this.descuento = builder.descuento;
        this.metodoPago = builder.metodoPago;
    }

    public void mostrarFactura() {
        double total = subtotal + impuestos - descuento;

        System.out.println("FACTURA");
        System.out.println("Número: " + numero);
        System.out.println("Cliente: " + cliente);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Impuestos: " + impuestos);
        System.out.println("Descuento: " + descuento);
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("TOTAL: " + total);
    }

    public static class Builder {

        private String numero;
        private String cliente;
        private double subtotal;
        private double impuestos;
        private double descuento;
        private String metodoPago;

        public Builder setNumero(String numero) {
            this.numero = numero;
            return this;
        }

        public Builder setCliente(String cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder setSubtotal(double subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        public Builder setImpuestos(double impuestos) {
            this.impuestos = impuestos;
            return this;
        }

        public Builder setDescuento(double descuento) {
            this.descuento = descuento;
            return this;
        }

        public Builder setMetodoPago(String metodoPago) {
            this.metodoPago = metodoPago;
            return this;
        }

        public Factura build() {
            return new Factura(this);
        }
    }
}
