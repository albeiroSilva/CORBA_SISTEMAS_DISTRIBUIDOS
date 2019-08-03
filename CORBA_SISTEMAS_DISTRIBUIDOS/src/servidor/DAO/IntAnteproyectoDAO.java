/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.sql.SQLException;
import sop_corba.GestionAnteproyectosPackage.anteproyectoDTO;


/**
 *
 * @author USERPC
 */
public interface IntAnteproyectoDAO {
    public boolean registrarAnteproyecto(anteproyectoDTO objAnteproyecto) throws SQLException;
    public anteproyectoDTO[] listarAnteproyectos()throws SQLException ;
    public anteproyectoDTO buscarAnteproyecto(int codigo)throws SQLException ;
    public long numeroFilas()throws SQLException;
    public boolean cambiarConceptoAnteproyecto(int codigo) throws SQLException; 
}
