package PATRONES.observer_singleton_facade;

public class Factura {
    private int numero;
    private String cliente;
    private String metodoPago;

    private Factura(Builder builder){
        this.numero = builder.numero;
        this.cliente = builder.cliente;
        this.metodoPago = builder.metodoPago;
    }

    public static class Builder {

        private int numero;
        private String cliente;
        private String metodoPago;

        public Builder numero(int numero) {
            this.numero = numero;
            return this;
        }

        public Builder cliente(String cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder metodoPago(
                String metodoPago) {

            this.metodoPago = metodoPago;
            return this;
        }

        public Factura build() {
            return new Factura(this);
        }
    }

    @Override
    public String toString() {

        return "Factura{" +
                "numero=" + numero +
                ", cliente='" + cliente + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                '}';
    }

}
