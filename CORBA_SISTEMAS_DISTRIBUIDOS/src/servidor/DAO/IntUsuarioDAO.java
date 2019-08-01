/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.sql.SQLException;
import sop_corba.GestionAnteproyectosPackage.usuarioDTO;
import sop_corba.GestionAnteproyectosPackage.usuarioIngresadoDTO;


/**
 *
 * @author USERPC
 */
public interface IntUsuarioDAO {    
    public boolean registrarUsuario(usuarioDTO objUsuario)throws SQLException;
    public boolean guardarCredencialesUsuario(String usuario, String contrasenia)throws SQLException ;
    public usuarioDTO[] listarUsuarios()throws SQLException ;
    public usuarioIngresadoDTO[] listarUsuariosIngresados();
    public usuarioIngresadoDTO recuperarUsuario()throws SQLException;
}
