/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import servidor.BD.clsConexion;
import servidor.BD.clsConsultas;
import sop_corba.GestionAnteproyectosPackage.usuarioDTO;
import sop_corba.GestionAnteproyectosPackage.usuarioIngresadoDTO;


/**
 *
 * @author USERPC
 */
public class ClsUsuarioDAOImpl implements IntUsuarioDAO{

    private clsConsultas objConsultas;
    private clsConexion objConexion;
    
    public ClsUsuarioDAOImpl() {
        objConsultas = new clsConsultas();
        objConexion = new clsConexion();
    }
    
    

    @Override
    public boolean registrarUsuario(usuarioDTO objUsuario)throws SQLException {
        boolean bandera = false;
        
        if (!verificarExistenciaDeUsuario(objUsuario.getUsuarioUnicauca())) {
            Connection cn = objConexion.ConectarMySQL();

            String identificacion = Integer.toString(objUsuario.getIdentificacion());
            String nombre_ape = objUsuario.getNombreApellidos();
            String usuarioUnicauca = objUsuario.getUsuarioUnicauca();
            String contrasenia = objUsuario.getContrasenia();
            String tipoUsuario = objUsuario.getTipoUsuario();

            String varConsulta = objConsultas.registrarUsuario();
            PreparedStatement pst = cn.prepareStatement(varConsulta);

            pst.setString(1, identificacion);
            pst.setString(2, nombre_ape);
            pst.setString(3, usuarioUnicauca);
            pst.setString(4, contrasenia);
            pst.setString(5, tipoUsuario);

            int n = pst.executeUpdate();
            if (n > 0) {
                bandera = true;
            }
        }
        return bandera;
        
    }

    @Override
    public boolean guardarCredencialesUsuario(String usuario, String contrasenia)throws SQLException {
        boolean bandera = false;
        
        Connection cn = objConexion.ConectarMySQL();
       
        String varConsulta = objConsultas.registrarUsuarioIngresado();
        PreparedStatement pst = cn.prepareStatement(varConsulta);
        
        pst.setString(1, usuario);
        pst.setString(2, contrasenia);
    
        
        int  n = pst.executeUpdate();
        if (n>0) {
            bandera = true;
        }
        return bandera;
    }

    @Override
    public usuarioDTO[] listarUsuarios() throws SQLException {

        int numeroDeUsuarios = numeroDeUsuarios();
        usuarioDTO[] usuarios = new usuarioDTO[numeroDeUsuarios];
        
        ArrayList<usuarioDTO> listaUsuarios = new ArrayList<usuarioDTO>();
        String varConsulta = objConsultas.listarUsuarios();
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);
        
        while (rs.next()) {            
            usuarioDTO objUsuario = new usuarioDTO();
            
            objUsuario.setIdentificacion(Integer.parseInt(rs.getString(1)));
            objUsuario.setNombreApellidos(rs.getString(2));
            objUsuario.setUsuarioUnicauca(rs.getString(3));
            objUsuario.setContrasenia(rs.getString(4));
            objUsuario.setTipoUsuario(rs.getString(5));
            listaUsuarios.add(objUsuario);
        }
        
        return listaUsuarios.toArray(usuarios);
    }

    @Override
    public usuarioIngresadoDTO[] listarUsuariosIngresados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public usuarioIngresadoDTO recuperarUsuario()throws SQLException {
        
        String varConsulta = objConsultas.recuperarIdUsuario();
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);
        usuarioIngresadoDTO objUsuarioIngresado = new usuarioIngresadoDTO();
        
        while (rs.next()) {   
            
            objUsuarioIngresado.setContrasenia(rs.getString(1));
            objUsuarioIngresado.setContrasenia(rs.getString(2));

            
        }
        return objUsuarioIngresado;
    }
    
    public int numeroDeUsuarios() throws SQLException{
        
        String varConsulta = objConsultas.numeroDeFilasUsuarios();
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);
        String numeroFilas = "";
        
        while (rs.next()) {            
            numeroFilas = rs.getString(1);
        }
        return  Integer.parseInt(numeroFilas);
    }
    
    public boolean verificarExistenciaDeUsuario(String usuario)throws SQLException{
        boolean bandera = false;
        String varConsulta = objConsultas.verificarExistenciaDeUsuario(usuario);
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);
        String usuarioE = "";
        
        while (rs.next()) {            
            usuarioE = rs.getString(1);
        }
        if (usuario.equals(usuarioE)) {
            bandera = true;
        }
        return bandera;
    }
    
}
