/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.BD.clsConexion;
import servidor.BD.clsConsultas;
import sop_corba.GestionAnteproyectosPackage.usuarioDTO;


/**
 *
 * @author USERPC
 */
public class ClsInicioSesionDAOImpl implements IntInicioDeSesionDAO {

    private clsConsultas objConsultas;
    private clsConexion objConexion;

    public ClsInicioSesionDAOImpl() {
        objConsultas = new clsConsultas();
        objConexion = new clsConexion();
    }
    
    @Override
    public usuarioDTO verificarCredenciales(String usuario, String contrasenia)throws SQLException {
        
        PreparedStatement sentencia = null;
        String consulta = objConsultas.verificarCredenciales(usuario, contrasenia);
        sentencia = objConexion.ConectarMySQL().prepareStatement(consulta);
        sentencia.setString(1, usuario);
        sentencia.setString(2, contrasenia);
        ResultSet rs = sentencia.executeQuery();
        
        usuarioDTO objUsuario = new usuarioDTO();
        
        int identificacion = 0;
        String tipoUsuario = "";
       
           while (rs.next()) {
            identificacion = Integer.parseInt(rs.getString(1));
            objUsuario.setIdentificacion(identificacion);
            objUsuario.setNombreApellidos(rs.getString(2));
            objUsuario.setUsuarioUnicauca(rs.getString(3));
            objUsuario.setContrasenia(rs.getString(4));
            tipoUsuario = rs.getString(5);

            if (tipoUsuario.equals("2")) {

                String tipoU = "";
                
                String varConsultaId = objConsultas.obtenerTipoUsuario(identificacion);                
                ResultSet rs1 = objConexion.ObtenerObjDeConsulta(varConsultaId);
                while (rs1.next()) {
                    tipoU = rs1.getString(1);
                }
                System.out.println("tipoUsuario: "+tipoU);
                if (tipoU != null) {
                    if (tipoU.equals("2")) {
                        objUsuario.setTipoUsuario("2");
                    } else {
                        objUsuario.setTipoUsuario("4");
                    }
                }else{
                    objUsuario.setTipoUsuario("5");
                }
            }else{
                objUsuario.setTipoUsuario(rs.getString(5));
            }
        }
           

        return objUsuario;
        
    }

    
}

