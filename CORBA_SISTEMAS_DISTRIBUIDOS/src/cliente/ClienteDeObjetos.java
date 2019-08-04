package cliente;

import cliente.vistas.ClienteImpl;
import cliente.vistas.ClsLogin;
import cliente.vistas.ClsMenuEvaluador;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import sop_corba.*;
import sop_corba.GestionAnteproyectosPackage.anteproyectoDTOHolder;


public class ClienteDeObjetos
{
  //*** Atributo estático ***
  static GestionAnteproyectosOperations ref;
  static ClsLogin objLogin;
  static ClienteInt objcllbck;
  static ClienteImpl clienteCallbackImpl;
 
  
  public static void main(String args[])
    {
      try{
      // crea e iniciia el ORB
      String[] vector = new String[]{"-ORBInitialHost","localhost", "-ORBInitialPort", "2020"};
	ORB orb = ORB.init(vector, null);
//
//        POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
//        rootpoa.the_POAManager().activate();
        // obtiene la base del naming context
        org.omg.CORBA.Object objRef = 
	    orb.resolve_initial_references("NameService");     
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
        // *** Resuelve la referencia del objeto en el N_S ***
        String name = "objAnteproyectos";
        ref = GestionAnteproyectosHelper.narrow(ncRef.resolve_str(name));
        
          
//         clienteCallbackImpl = new ClienteImpl();
//
//         org.omg.CORBA.Object ref2 = rootpoa.servant_to_reference(clienteCallbackImpl);
//
//          // obtiene la referencia del objeto callback
//          objcllbck = ClienteIntHelper.narrow(ref2);
//
//          //registra el objcllbck el cual representa el cliente en el servidor de chat
//          ref.registrarCliente(objcllbck);

        System.out.println("Obtenido el manejador sobre el servidor de objetos: " +ref);
        objLogin = new ClsLogin(ref);
        objLogin.setVisible(true);
      

	} catch (Exception e) {
          System.out.println("ERROR : " + e) ;
	  e.printStackTrace(System.out);
	  }
    }

}

