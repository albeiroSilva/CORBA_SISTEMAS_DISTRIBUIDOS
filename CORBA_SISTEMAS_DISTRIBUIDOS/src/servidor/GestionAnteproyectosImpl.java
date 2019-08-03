/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.BooleanHolder;
import servidor.DAO.ClsAnteproyectoDAOImpl;
import servidor.DAO.ClsEvaluadorDAOImpl;
import servidor.DAO.ClsInicioSesionDAOImpl;
import servidor.DAO.ClsUsuarioDAOImpl;
import servidor.DAO.IntAnteproyectoDAO;
import servidor.DAO.IntEvaluadorDAO;
import servidor.DAO.IntInicioDeSesionDAO;
import servidor.DAO.IntUsuarioDAO;
import sop_corba.ClienteInt;
import sop_corba.GestionAnteproyectosPOA;
import sop_corba.GestionAnteproyectosPackage.anteproyectoDTO;
import sop_corba.GestionAnteproyectosPackage.anteproyectoDTOHolder;
import sop_corba.GestionAnteproyectosPackage.evaluadoresDTO;
import sop_corba.GestionAnteproyectosPackage.usuarioDTO;
import sop_corba.GestionAnteproyectosPackage.usuarioIngresadoDTO;

public class GestionAnteproyectosImpl extends GestionAnteproyectosPOA {

    IntInicioDeSesionDAO objInicioSesionDAO;
    IntUsuarioDAO objUsuarioDAO;
    IntAnteproyectoDAO objAnteproyectoDAO;
    IntEvaluadorDAO objEvaluadorDAO;
     List<ClienteInt> usuarios;

    public GestionAnteproyectosImpl() {
        objInicioSesionDAO = new ClsInicioSesionDAOImpl();
        objUsuarioDAO = new ClsUsuarioDAOImpl();
        objAnteproyectoDAO = new ClsAnteproyectoDAOImpl();
        objEvaluadorDAO = new ClsEvaluadorDAOImpl();
        usuarios = new ArrayList<>();
    }
    
    @Override
    public usuarioDTO verificarCredenciales(String usuario, String contrasenia) {
        System.out.println("verificando credenciales");

        usuarioDTO objUsuario = null;
        try {
            objUsuario = objInicioSesionDAO.verificarCredenciales(usuario, contrasenia);
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objUsuario;
    }

    @Override
    public boolean registrarAnteproyecto(anteproyectoDTO objAnteproyecto) {
        System.out.println("Registrando Anteproyecto");
        boolean bandera = false;
        try {
            
            objAnteproyectoDAO.registrarAnteproyecto(objAnteproyecto);
            bandera = true;
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bandera;
    }

    @Override
    public boolean registrarUsuario(usuarioDTO objUsuario) {
        System.out.println("Registrando Usuario");
        boolean bandera = false;
        try {
            if(objUsuarioDAO.registrarUsuario(objUsuario)){
                bandera = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        }
        return bandera;
    }

    @Override
    public anteproyectoDTO[] listarAnteproyectos() {
        System.out.println("Listando Anteproyectos");
        anteproyectoDTO[] anteproyectos = null;
        try {
            anteproyectos = objAnteproyectoDAO.listarAnteproyectos();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return anteproyectos;
    }

    @Override
    public anteproyectoDTO buscarAnteproyecto(int codigo) {
        System.out.println("Buscando Anteproyecto");
        anteproyectoDTO objAnteproyecto = null;
        try {
            objAnteproyecto = objAnteproyectoDAO.buscarAnteproyecto(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objAnteproyecto;
    }

    @Override
    public boolean asignarEvaluador(int codigo, evaluadoresDTO objEvaluador) {
        System.out.println("Asignando Evaluador");
        boolean bandera = false;

        try {
            if (objEvaluadorDAO.asignarEvaluador(codigo, objEvaluador)) {
                System.out.println("Notificando");
                notificar();
                bandera = true;
            } 

        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);

        }
        return bandera;
    }

    @Override
    public int numeroFilas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public evaluadoresDTO buscarEvaluador(int codigo) {
        System.out.println("Buscando Evaluador");
        evaluadoresDTO objEvaluador = null;
        try {
            objEvaluador = objEvaluadorDAO.buscarEvaluador(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objEvaluador;
    }

    @Override
    public boolean cambiarConceptoAnteproyecto(int codigo) {
        System.out.println("Cambiando Concepto Jefe");
        boolean bandera = false;
        try {
            objAnteproyectoDAO.cambiarConceptoAnteproyecto(codigo);
            bandera = true;
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        }
        return bandera;
    }

    @Override
    public boolean guardarCredencialesUsuario(String usuario, String contrasenia) {
        boolean bandera = false;
        try {
            objUsuarioDAO.guardarCredencialesUsuario(usuario, contrasenia);
            bandera = true;
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        }
        return bandera;
    }

    @Override
    public boolean aniadirConceptoEvaluador(int codigo, String concepto) {
        System.out.println("Añadiendo Concepto Evaluador");
        boolean bandera = false;
        try {
            if(objEvaluadorDAO.aniadirConceptoEvaluador(codigo, Integer.parseInt(concepto))){
                bandera = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bandera;
    }

    @Override
    public usuarioIngresadoDTO recuperarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public usuarioDTO[] listarUsuarios() {
        System.out.println("Listando Usuarios");
        usuarioDTO[]usuarios = null;
        try {
            usuarios = objUsuarioDAO.listarUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }

    @Override
    public evaluadoresDTO[] listarEvaluadores() {
        evaluadoresDTO[] evaluadores = null;
        try {
            evaluadores = objEvaluadorDAO.listarEvaluadores();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnteproyectosImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evaluadores;
    }

    @Override
    public usuarioIngresadoDTO[] listarUsuariosIngresados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarCliente(ClienteInt objcllbck) {
        System.out.println("Registrando cliente callback");
        boolean registro = false;
        if (!usuarios.contains(objcllbck)) {
            registro = usuarios.add(objcllbck);
            
            
        }
       
        return registro;
    }

    public void notificar() {

        for (ClienteInt usuario : usuarios) {

            usuario.recibirMensaje("Se le acaba de asignar un Anteproyecto");

        }

    }
}
