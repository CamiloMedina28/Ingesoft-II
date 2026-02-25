package Solid.SRP.CorrectImplementation;

class Factura {

    private double[] productos;

    public Factura(double[] productos) {
        this.productos = productos;
    }

    public double calcularTotal() {
        double total = 0;
        for (double precio : productos) {
            total += precio;
        }
        return total;
    }
}