/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import sop_corba.GestionAnteproyectosPackage.usuarioDTO;


/**
 *
 * @author USERPC
 */
public interface IntInicioDeSesionDAO {   
    public usuarioDTO verificarCredenciales(String usuario, String contrasenia)throws SQLException;
}
