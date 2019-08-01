package servidor.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class clsConexion {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/gestionanteproyectos";
    private String error = "";

    public clsConexion() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexión establecida");
       
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurrió algún error");
        }
    }
    
    

    public Connection ConectarMySQL() {
        return conn;
    }
    public void desconectar(){
        conn = null;
        if (conn == null) {
            System.out.println("Conexión terminada");
        }
    }
    public ResultSet ObtenerObjDeConsulta(String pConsulta) {
        try {
            Connection conexion = ConectarMySQL();
            Statement sentencia = conexion.createStatement();
            ResultSet rt = sentencia.executeQuery(pConsulta);
            return rt;
        }catch (SQLException ex) {
            this.error = ex.getMessage();
            JOptionPane.showMessageDialog(null, "ERROR AL CONSULTAR");
            return null;
        }
    }

}
   
