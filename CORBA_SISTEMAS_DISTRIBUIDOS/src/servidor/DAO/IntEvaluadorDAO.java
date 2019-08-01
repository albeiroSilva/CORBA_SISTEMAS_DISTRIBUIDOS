/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.sql.SQLException;
import sop_corba.GestionAnteproyectosPackage.evaluadoresDTO;


/**
 *
 * @author USERPC
 */
public interface IntEvaluadorDAO {   
    public boolean asignarEvaluador(int codigo, evaluadoresDTO objEvaluador)throws SQLException;
    public boolean registrarEvaluador(evaluadoresDTO objEvaluador) ;
    public evaluadoresDTO buscarEvaluador(int codigo) throws SQLException;
    public evaluadoresDTO[] listarEvaluadores()throws SQLException;
    public boolean aniadirConceptoEvaluador(int codigo, int concepto)throws SQLException;
}
