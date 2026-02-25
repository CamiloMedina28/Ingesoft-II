package Solid.SRP.CorrectImplementation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class FacturaRepository {
    public Connection conectar(){
        /* No es buena práctica tener hardcodeados los datos de conexión
        de la base de datos. No obstante, a forma de ejemplo para el ejercicio
        se agregan directamente. */
        String url = "jdbc:mysql://localhost:3306/mi_base_datos";
        String user = "root";
        String password = "password";

        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            return conexion;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void close(Connection conexion) throws SQLException{
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void guardar(Factura factura) {
        Connection connection = this.conectar();
        PreparedStatement ps = null;

        try{
            String sql_query = "INSERT INTO factura (total) VALUES (?)";
            ps = connection.prepareStatement(sql_query);

            double total = factura.calcularTotal();
            ps.setDouble(0, total); // prevención de inyección sql
            ps.executeUpdate();
        }catch (SQLException exception){
            exception.printStackTrace();
        }finally{
            try{
                if (ps != null) ps.close();
                if (connection != null) this.close(connection);
            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }
    }
}