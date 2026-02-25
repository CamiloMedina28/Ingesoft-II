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

    public void guardarEnBaseDeDatos() {
        System.out.println("Guardando factura en la base de datos...");
    }

    public void enviarCorreo() {
        System.out.println("Enviando factura por correo...");
    }
}