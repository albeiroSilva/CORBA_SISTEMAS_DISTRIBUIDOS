/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.vistas;

import java.rmi.RemoteException;
import sop_corba.ClienteIntPOA;


/**
 *
 * @author USERPC
 */
public class ClienteImpl extends ClienteIntPOA{

    
    ClsMenuEvaluador objEvaluador;
    public ClienteImpl(ClsMenuEvaluador objEvaluador){
        this.objEvaluador = objEvaluador;
    }

    
    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("Recibiendo Contacto");
        System.out.println("mensaje: "+ mensaje);
        objEvaluador.fijarTexto(mensaje);
    }
    
}
