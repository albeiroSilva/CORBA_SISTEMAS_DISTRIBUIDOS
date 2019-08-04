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
import sop_corba.GestionAnteproyectosPackage.evaluadoresDTO;


/**
 *
 * @author USERPC
 */
public class ClsEvaluadorDAOImpl implements IntEvaluadorDAO {

    private clsConsultas objConsultas;
    private clsConexion objConexion;

    public ClsEvaluadorDAOImpl() {
        objConsultas = new clsConsultas();
        objConexion = new clsConexion();
    }
    
    @Override
    public boolean asignarEvaluador(int codigo, evaluadoresDTO objEvaluador)throws SQLException {
        
         boolean bandera = false;
        
        Connection cn = objConexion.ConectarMySQL();
        
        String codigoO = Integer.toString(objEvaluador.getCodigo());
        String evaluador_1 = objEvaluador.getEvaluador_1();
        String conceptoEvaluador_1 = objEvaluador.getConceptoEvaluador_1();
        String fechaRevision_1 = objEvaluador.getFechaRevision_1();
        String evaluador_2 = objEvaluador.getEvaluador_2();
        String conceptoEvaluador_2 = objEvaluador.getConceptoEvaluador_2();
        String fechaRevision_2 = objEvaluador.getFechaRevision_2();
        
        String evaluador1 = objEvaluador.getEvaluador_1();
        String varEva1 = objConsultas.buscarIdeUsuario(evaluador1);
        String idE1 = "";
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varEva1);
        while (rs.next()) {            
            idE1 = rs.getString(1); 
        }
        
        String evaluador2 = objEvaluador.getEvaluador_2();
        String varEva2 = objConsultas.buscarIdeUsuario(evaluador2);
        String idE2 = "";
        ResultSet rs2 = objConexion.ObtenerObjDeConsulta(varEva2);
        while (rs2.next()) {            
            idE2 = rs2.getString(1); 
        }
       
        
        String varConsulta = objConsultas.registrarusuarioAnteproyecto();
        PreparedStatement pst = cn.prepareStatement(varConsulta);
        
        pst.setString(1, idE1);
        pst.setString(2, codigoO);
        pst.setString(3, "2");
        pst.setString(4, conceptoEvaluador_1);
        pst.setString(5, fechaRevision_1);
        pst.setString(6, fechaRevision_2);
  
        int n = pst.executeUpdate();
            
        String varConsulta2 = objConsultas.registrarusuarioAnteproyecto();
        PreparedStatement pst2 = cn.prepareStatement(varConsulta2);
        
        pst2.setString(1, idE2);
        pst2.setString(2, codigoO);
        pst2.setString(3, "2");
        pst2.setString(4, conceptoEvaluador_2);
        pst2.setString(5, fechaRevision_1);
        pst2.setString(6, fechaRevision_2);   
        
        int n2 = pst2.executeUpdate();
            
            if (n > 0 && n2 > 0) {
                actualizarEstado(codigo);
                bandera = true;
            }
        
            //System.out.println("codigo ya existe");
            
        
        return bandera;
    }

    @Override
    public boolean registrarEvaluador(evaluadoresDTO objEvaluador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public evaluadoresDTO buscarEvaluador(int codigo)throws SQLException {
        
        String varConsulta = objConsultas.obtenerEvaluador1(codigo);
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);
        String evaluador1 = "";
        while (rs.next()) {            
            evaluador1 = rs.getString(1);
        }
        
        String varConsulta1 = objConsultas.obtenerEvaluador2(codigo);
        ResultSet rs1 = objConexion.ObtenerObjDeConsulta(varConsulta1);
        String evaluador2 = "";
        while (rs1.next()) {            
            evaluador2 = rs1.getString(1);
        }
        
        String varConsulta2 = objConsultas.obtenerConceptoEvaluador1(evaluador1, codigo);
        ResultSet rs2 = objConexion.ObtenerObjDeConsulta(varConsulta2);
        String conceptoEvaluador1 = "";
        while (rs2.next()) {            
            conceptoEvaluador1 = rs2.getString(1);
        }
        
        String varConsulta3 = objConsultas.obtenerConceptoEvaluador2(evaluador2, codigo);
        ResultSet rs3 = objConexion.ObtenerObjDeConsulta(varConsulta3);
        String conceptoEvaluador2 = "";
        while (rs3.next()) {            
            conceptoEvaluador2 = rs3.getString(1);
        }
        
        
        evaluadoresDTO objEvaluador = new evaluadoresDTO();
        
  
            System.out.println("concepto1: "+conceptoEvaluador1);
            System.out.println("concepto2: "+conceptoEvaluador2);
            objEvaluador.setCodigo(codigo);
            objEvaluador.setEvaluador_1(evaluador1);
            objEvaluador.setConceptoEvaluador_1(conceptoEvaluador1);
            objEvaluador.setFechaRevision_1("");
            objEvaluador.setEvaluador_2(evaluador2);
            objEvaluador.setConceptoEvaluador_2(conceptoEvaluador2);
            objEvaluador.setFechaRevision_2("");
            

        return objEvaluador;
    }

    @Override
    public evaluadoresDTO[] listarEvaluadores() throws SQLException{
        int numeroDeEvaluadores = numeroDeEvaluadores();
        evaluadoresDTO[] evaluadores = new evaluadoresDTO[numeroDeEvaluadores];

        ArrayList<evaluadoresDTO> listaEvaluadores = new ArrayList<evaluadoresDTO>();
        String varConsulta = objConsultas.listarEvaluadores();
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);

        while (rs.next()) {
            evaluadoresDTO objEvaluador = new evaluadoresDTO();
            
            objEvaluador.setCodigo(Integer.parseInt(rs.getString(1)));
            objEvaluador.setEvaluador_1(rs.getString(2));
            objEvaluador.setConceptoEvaluador_1(rs.getString(3));
            objEvaluador.setFechaRevision_1(rs.getString(4));
            objEvaluador.setEvaluador_2(rs.getString(5));
            objEvaluador.setConceptoEvaluador_2(rs.getString(6));
            objEvaluador.setFechaRevision_2(rs.getString(7));
         
            listaEvaluadores.add(objEvaluador);

        }

        return listaEvaluadores.toArray(evaluadores);
    }

    @Override
    public boolean aniadirConceptoEvaluador(int codigo, int concepto)throws SQLException {
        
        boolean bandera = false;
      
        String varConsulta1 = objConsultas.recuperarIdUsuario();
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta1);
        
        int idUsuario = 0 ; 
        while (rs.next()) {            
            idUsuario = Integer.parseInt(rs.getString(1));
        }
        
        String varConsulta2 = objConsultas.verificarSiEsEvaluadorDelA(codigo);
        ResultSet rs2= objConexion.ObtenerObjDeConsulta(varConsulta2);
        
        int idUsuarioVerificado = 0 ; 
        while (rs2.next()) {            
            idUsuarioVerificado = Integer.parseInt(rs2.getString(1));
        } 
        
        if (idUsuario == idUsuarioVerificado) {

            Connection cn = objConexion.ConectarMySQL();
            
                String varConsulta = objConsultas.aniadirConceptoEvaluador();
                PreparedStatement pst = cn.prepareStatement(varConsulta);

                pst.setString(1, Integer.toString(concepto));
                pst.setString(2, Integer.toString(codigo));
                pst.setString(3, Integer.toString(idUsuario));

                int n = pst.executeUpdate();
                if (n > 0) {
                    bandera = true;
                    cambiarEstado(codigo);
                }
            

        }
        return bandera;
    }
    public boolean verificarCodigoExistente(int codigo) throws SQLException{
        boolean bandera = false;
        String varConsulta = objConsultas.verificarCodigoExistente(codigo);
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);
        
        evaluadoresDTO objEvaluador = new evaluadoresDTO();
        while (rs.next()) {            
            objEvaluador.setCodigo(Integer.parseInt(rs.getString(1)));
        }
        if (objEvaluador.getCodigo() == codigo) {
            bandera = true;
        }
        return bandera;
    } 
   
    public boolean actualizarEstado(int codigo) throws SQLException{
        boolean bandera = false;
        
        Connection cn = objConexion.ConectarMySQL();
        String varConsulta = objConsultas.actualizarEstado();
        PreparedStatement pst = cn.prepareStatement(varConsulta);
        
        pst.setString(1, Integer.toString(2));
        pst.setString(2, Integer.toString(codigo));
        
        int n = pst.executeUpdate();
        if (n > 0) {
            bandera = true;
        }
        
        return bandera;
    }
    
    public int numeroDeEvaluadores() throws SQLException{
        
        String varConsulta = objConsultas.numeroDeFilasEvaluadores();
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);
        int numeroFilas = 0;
        
        while (rs.next()) {            
            numeroFilas = Integer.parseInt(rs.getString(1));
        }
        return numeroFilas;
    }
    public boolean cambiarEstado(int codigo) throws SQLException {

        boolean bandera = false;
        String varConsulta2 = objConsultas.recuperarEstado(codigo);
        ResultSet rs2 = objConexion.ObtenerObjDeConsulta(varConsulta2);

        int estado = 0;

        while (rs2.next()) {
            estado = Integer.parseInt(rs2.getString(1));
        }

        Connection cn = objConexion.ConectarMySQL();
        String varConsulta = objConsultas.actualizarEstado();
        PreparedStatement pst = cn.prepareStatement(varConsulta);

        if (estado == 2) {

            pst.setString(1, "3");
            pst.setString(2, Integer.toString(codigo));

        } else {
            pst.setString(1, "4");
            pst.setString(2, Integer.toString(codigo));
        }

        int n = pst.executeUpdate();
        if (n > 0) {
            bandera = true;
        }

        return bandera;
    }


}
