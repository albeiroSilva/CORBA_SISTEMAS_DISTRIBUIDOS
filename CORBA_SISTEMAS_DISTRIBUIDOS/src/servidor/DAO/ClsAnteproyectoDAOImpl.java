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
import sop_corba.GestionAnteproyectosPackage.anteproyectoDTO;
import sop_corba.GestionAnteproyectosPackage.evaluadoresDTO;


/**
 *
 * @author USERPC
 */
public class ClsAnteproyectoDAOImpl implements IntAnteproyectoDAO{
    
    private clsConsultas objConsultas;
    private clsConexion objConexion;

    public ClsAnteproyectoDAOImpl() {
        objConsultas = new clsConsultas();
        objConexion = new clsConexion();
    }
    
    

    @Override
    public boolean registrarAnteproyecto(anteproyectoDTO objAnteproyecto) throws SQLException{
        boolean bandera = false;
        
        Connection cn = objConexion.ConectarMySQL();
        
        String codigo = Integer.toString((int) (numeroFilas()+1));
        String modalidad = objAnteproyecto.getModalidad();
        String titulo = objAnteproyecto.getTitulo();
        String concepto = Integer.toString(2);
        String estado = Integer.toString(1);
        String numeroRevision = Integer.toString(0);
        String fechaIngreso = objAnteproyecto.getFechaIngreso();
        String fechaAprobacion = objAnteproyecto.getFechaAprobacion();
        
        
        String varConsulta = objConsultas.registrarAnteproyectos();
        PreparedStatement pst = cn.prepareStatement(varConsulta);
        
        pst.setString(1, codigo);
        pst.setString(2, modalidad);
        pst.setString(3, titulo);
        pst.setString(4, concepto);
        pst.setString(5, estado);
        pst.setString(6, numeroRevision);
        pst.setString(7, fechaIngreso);
        pst.setString(8, fechaAprobacion);
        
        int  n = pst.executeUpdate();
        
        String estudiante1 = objAnteproyecto.getEstudiante_1();
        String varConsultaId = objConsultas.buscarIdeUsuario(estudiante1);
        String idE1 = "";
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsultaId);
        while (rs.next()) {            
            idE1 = rs.getString(1); 
        }
        
        String estudiante2 = objAnteproyecto.getEstudiante_2();
        String varConsultaId2 = objConsultas.buscarIdeUsuario(estudiante2);
        ResultSet rs2 = objConexion.ObtenerObjDeConsulta(varConsultaId2);
        String idE2 = "";
        while (rs2.next()) {            
            idE2 = rs2.getString(1); 
        }
        
        String director = objAnteproyecto.getDirector();
        String varConsultaId3 = objConsultas.buscarIdeUsuario(director);
        ResultSet rs3 = objConexion.ObtenerObjDeConsulta(varConsultaId3);
         String idE3 = "";
        while (rs3.next()) {            
            idE3 = rs3.getString(1); 
        }
        
        String co_director = objAnteproyecto.getCo_director();
        String varConsultaId4 = objConsultas.buscarIdeUsuario(co_director);
        ResultSet rs4 = objConexion.ObtenerObjDeConsulta(varConsultaId4);
         String idE4 = "";
        while (rs4.next()) {            
            idE4 = rs4.getString(1); 
        }
        
        String rolE = "1";
        String conceptou="0";
        
        String varConsultaU = objConsultas.registrarusuarioAnteproyecto();
        PreparedStatement pstU = cn.prepareStatement(varConsultaU);
        
        pstU.setString(1, idE1);
        pstU.setString(2, codigo);
        pstU.setString(3, rolE);
        pstU.setString(4, conceptou);
        pstU.setString(5, objAnteproyecto.getFechaIngreso());
        pstU.setString(6, objAnteproyecto.getFechaAprobacion());
        
        int n4 = pstU.executeUpdate();
        
        String varConsultaU1 = objConsultas.registrarusuarioAnteproyecto();
        PreparedStatement pstU1 = cn.prepareStatement(varConsultaU1);
        
        pstU1.setString(1, idE2);
        pstU1.setString(2, codigo);
        pstU1.setString(3, rolE);
        pstU1.setString(4, conceptou);
        pstU1.setString(5, objAnteproyecto.getFechaIngreso());
        pstU1.setString(6, objAnteproyecto.getFechaAprobacion());
        
        int n1 = pstU1.executeUpdate();
        
        String varConsultaU2 = objConsultas.registrarusuarioAnteproyecto();
        PreparedStatement pstU2 = cn.prepareStatement(varConsultaU2);
        
        pstU2.setString(1, idE3);
        pstU2.setString(2, codigo);
        pstU2.setString(3, "3");
        pstU2.setString(4, conceptou);
        pstU2.setString(5, objAnteproyecto.getFechaIngreso());
        pstU2.setString(6, objAnteproyecto.getFechaAprobacion());
        
        int n2 = pstU2.executeUpdate();
        
        String varConsultaU3 = objConsultas.registrarusuarioAnteproyecto();
        PreparedStatement pstU3 = cn.prepareStatement(varConsultaU3);
        
        pstU3.setString(1, idE4);
        pstU3.setString(2, codigo);
        pstU3.setString(3, "4");
        pstU3.setString(4, conceptou);
        pstU3.setString(5, objAnteproyecto.getFechaIngreso());
        pstU3.setString(6, objAnteproyecto.getFechaAprobacion());
        
        int n3 = pstU3.executeUpdate();
        
        
        
        
        
        if (n>0 && n1>0 && n2> 0 && n3>0 && n4>0) {
            bandera = true;
        }
        return bandera;
    }

    @Override
    public anteproyectoDTO[] listarAnteproyectos() throws SQLException {
        int numeroDeAnteproyectos = (int) numeroFilas();
        anteproyectoDTO[] anteproyectos = new anteproyectoDTO[numeroDeAnteproyectos];

        ArrayList<anteproyectoDTO> listaAnteproyectos = new ArrayList<anteproyectoDTO>();
        String varConsulta = objConsultas.listarAnteproyectos();
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);

        while (rs.next()) {
            anteproyectoDTO objAnteproyecto = new anteproyectoDTO();
            
            objAnteproyecto.setCodigo(Integer.parseInt(rs.getString(1)));
            objAnteproyecto.setModalidad(rs.getString(2));
            objAnteproyecto.setTitulo(rs.getString(3));
            objAnteproyecto.setConcepto(Integer.parseInt(rs.getString(4)));
            objAnteproyecto.setEstado(Integer.parseInt(rs.getString(5)));
            
            listaAnteproyectos.add(objAnteproyecto);

        }
        

        return listaAnteproyectos.toArray(anteproyectos);
    }

    @Override
    public anteproyectoDTO buscarAnteproyecto(int codigo)throws SQLException {
        
        String varConsulta = objConsultas.buscarAnteproyecto(codigo);
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);
        
        String varConsulta2 = objConsultas.obtenerEstudiante1(codigo);
        ResultSet rs2 = objConexion.ObtenerObjDeConsulta(varConsulta2);
        String estudiante1 = "";
        while(rs2.next()){
            estudiante1 = rs2.getString(1);
        }
        
        String varConsulta3 = objConsultas.obtenerEstudiante2(codigo);
        ResultSet rs3 = objConexion.ObtenerObjDeConsulta(varConsulta3);
        String estudiante2 = "";
        while (rs3.next()) {
            estudiante2 = rs3.getString(1);
        }
        
        String varConsulta4 = objConsultas.obtenerDirector(codigo);
        ResultSet rs4 = objConexion.ObtenerObjDeConsulta(varConsulta4);
        String director = "";
        while (rs4.next()) {
            director = rs4.getString(1);
        }
        
        String varConsulta5 = objConsultas.obtenerCoDirector(codigo);
        ResultSet rs5 = objConexion.ObtenerObjDeConsulta(varConsulta5);
        String coDirector = "";
        while (rs5.next()) {
            coDirector = rs5.getString(1);
        }
        
        
        anteproyectoDTO objAnteproyecto = new anteproyectoDTO();
        
        while (rs.next()) {   
            
            objAnteproyecto.setCodigo(Integer.parseInt(rs.getString(1)));
            objAnteproyecto.setModalidad(rs.getString(2));
            objAnteproyecto.setTitulo(rs.getString(3));
            objAnteproyecto.setDirector(director);
            objAnteproyecto.setCo_director(coDirector);
            objAnteproyecto.setEstudiante_1(estudiante1);
            objAnteproyecto.setEstudiante_2(estudiante2);
            objAnteproyecto.setConcepto(Integer.parseInt(rs.getString(4)));
            
            objAnteproyecto.setEstado(Integer.parseInt(rs.getString(5)));
            objAnteproyecto.setNumeroRevision(Integer.parseInt(rs.getString(6)));
            
        
            objAnteproyecto.setFechaIngreso(rs.getString(7));
            objAnteproyecto.setFechaAprobacion(rs.getString(8));
            
        }
        
        return objAnteproyecto;
    }

    @Override
    public long numeroFilas() throws SQLException{
        
        String varConsulta = objConsultas.numeroDeFilas();
        ResultSet rs = objConexion.ObtenerObjDeConsulta(varConsulta);
        String numeroFilas = "";
        
        while (rs.next()) {            
            numeroFilas = rs.getString(1);
        }
        
        return Integer.parseInt(numeroFilas);
    }

    @Override
    public boolean cambiarConceptoAnteproyecto(int codigo) throws SQLException {
        boolean bandera = false;
        
        String varConsultaEvaluador1 = objConsultas.sacarConceptos(codigo);
        ResultSet rs1 = objConexion.ObtenerObjDeConsulta(varConsultaEvaluador1);
        
        
        int conceptoEvaluador_1 = 0;
        int conceptoEvaluador_2 = 0;
        String nuevoConcepto;
        
        while (rs1.next()) {      
            
            conceptoEvaluador_1 = Integer.parseInt(rs1.getString(1));
        }
        
         String varConsultaEvaluador2 = objConsultas.sacarConceptos2(codigo);
        ResultSet rs2 = objConexion.ObtenerObjDeConsulta(varConsultaEvaluador2);
        
     
        while (rs2.next()) {      
            
            conceptoEvaluador_2 = Integer.parseInt(rs2.getString(1));
        }
        
        if (conceptoEvaluador_1 == 1 && conceptoEvaluador_2 == 1) {
            bandera = true;
            nuevoConcepto = Integer.toString(1);
        }else {
            bandera = true;
            nuevoConcepto = Integer.toString(2);
        }
        
        Connection cn = objConexion.ConectarMySQL();
        String varConsulta = objConsultas.cambiarConceptoAnteproyecto(codigo);
        PreparedStatement pst = cn.prepareStatement(varConsulta);

        pst.setString(1, nuevoConcepto);

        int n = pst.executeUpdate();
        if (n > 0) {
            bandera = true;
        }
        return bandera;
    }

    
  

}
