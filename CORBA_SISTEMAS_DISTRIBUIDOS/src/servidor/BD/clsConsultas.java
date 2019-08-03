
package servidor.BD;

import sop_corba.GestionAnteproyectosPackage.anteproyectoDTO;

public class clsConsultas {
    //Constructor.
    public clsConsultas(){}  
    
    //Metodos de consultas.
    
    public String listarAnteproyectos(){
        String varConsulta = "SELECT * FROM anteproyecto";
        return varConsulta;
    }
    
     public String registrarAnteproyectos(){
         
        String varConsulta = "INSERT INTO anteproyecto (codigoAnte, modalidad, titulo, concepto, estado,numeroRevision, fecha_registro, fecha_aprobación) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return varConsulta;
    }
    
      public String registrarusuarioAnteproyecto(){
         
        String varConsulta = "INSERT INTO usuario_anteproyecto (identificacion, codigoAnte, rolAnte, concepto, fecha_revision_1, fecha_revision_2) VALUES (?, ?, ?, ?, ?, ?)";
        return varConsulta;
    }
      
     public String buscarIdeUsuario(String nombre ){
         String varConsulta = "SELECT identificacion from usuarios WHERE usuarios.nombreApe = "+"'"+nombre+"'";
         return varConsulta;
     } 
     public String buscarAnteproyecto(int codigo){
         String varConsulta = "SELECT * FROM anteproyecto WHERE codigoAnte = "+codigo+"";
         return varConsulta;
     }
     public String obtenerEstudiante1(int codigo) {
        String varConsulta = "SELECT usuarios.nombreApe FROM usuarios WHERE identificacion = \n"
                + "(SELECT MIN(usuario_anteproyecto.identificacion) AS ID\n"
                + "FROM usuario_anteproyecto INNER JOIN anteproyecto ON (usuario_anteproyecto.codigoAnte = anteproyecto.codigoAnte)\n"
                + "WHERE usuario_anteproyecto.rolAnte = 1 AND anteproyecto.codigoAnte = "+codigo+" )";
        return varConsulta;
    }
    public String obtenerEstudiante2(int codigo) {
        String varConsulta = "SELECT usuarios.nombreApe FROM usuarios WHERE identificacion = \n"
                + "(SELECT MAX(usuario_anteproyecto.identificacion) AS ID\n"
                + "FROM usuario_anteproyecto INNER JOIN anteproyecto ON (usuario_anteproyecto.codigoAnte = anteproyecto.codigoAnte)\n"
                + "WHERE usuario_anteproyecto.rolAnte = 1 AND anteproyecto.codigoAnte = " + codigo + " )";
        return varConsulta;
    }
    public String obtenerDirector(int codigo) {
        String varConsulta = "SELECT usuarios.nombreApe FROM usuarios WHERE identificacion = \n"
                + "(SELECT usuario_anteproyecto.identificacion \n"
                + "FROM usuario_anteproyecto INNER JOIN anteproyecto ON (usuario_anteproyecto.codigoAnte = anteproyecto.codigoAnte)\n"
                + "WHERE usuario_anteproyecto.rolAnte = 3 AND anteproyecto.codigoAnte = " + codigo + " )";
        return varConsulta;
    }
      public String obtenerCoDirector(int codigo) {
        String varConsulta = "SELECT usuarios.nombreApe FROM usuarios WHERE identificacion = \n"
                + "(SELECT usuario_anteproyecto.identificacion \n"
                + "FROM usuario_anteproyecto INNER JOIN anteproyecto ON (usuario_anteproyecto.codigoAnte = anteproyecto.codigoAnte)\n"
                + "WHERE usuario_anteproyecto.rolAnte = 4 AND anteproyecto.codigoAnte = " + codigo + " )";
        return varConsulta;
    }
       public String obtenerEvaluador1(int codigo) {
        String varConsulta = "SELECT usuarios.usuario FROM usuarios WHERE identificacion = \n"
                + "(SELECT MAX(usuario_anteproyecto.identificacion) AS ID\n"
                + "FROM usuario_anteproyecto INNER JOIN anteproyecto ON (usuario_anteproyecto.codigoAnte = anteproyecto.codigoAnte)\n"
                + "WHERE usuario_anteproyecto.rolAnte = 2 AND anteproyecto.codigoAnte = " + codigo + " )";
        return varConsulta;
    }
     public String obtenerEvaluador2(int codigo) {
        String varConsulta = "SELECT usuarios.usuario FROM usuarios WHERE identificacion = \n"
                + "(SELECT MIN(usuario_anteproyecto.identificacion) AS ID\n"
                + "FROM usuario_anteproyecto INNER JOIN anteproyecto ON (usuario_anteproyecto.codigoAnte = anteproyecto.codigoAnte)\n"
                + "WHERE usuario_anteproyecto.rolAnte = 2 AND anteproyecto.codigoAnte = " + codigo + " )";
        return varConsulta;
    }
    public String obtenerConceptoEvaluador1(String nombre, int codigo) {
        String varConsulta = "SELECT usuario_anteproyecto.concepto \n"
                + "FROM usuario_anteproyecto \n"
                + "WHERE usuario_anteproyecto.identificacion =(SELECT usuarios.identificacion \n"
                + "from usuarios where usuarios.usuario = "+"'"+nombre+"'"+") AND usuario_anteproyecto.rolAnte = 2 AND usuario_anteproyecto.codigoAnte = "+codigo+"";
        return varConsulta;
    }
     public String obtenerConceptoEvaluador2(String nombre, int codigo) {
        String varConsulta = "SELECT usuario_anteproyecto.concepto \n"
                + "FROM usuario_anteproyecto \n"
                + "WHERE usuario_anteproyecto.identificacion =(SELECT usuarios.identificacion \n"
                + "from usuarios where usuarios.usuario = "+"'"+nombre+"'"+") AND usuario_anteproyecto.rolAnte = 2 AND usuario_anteproyecto.codigoAnte = "+codigo+"";
        return varConsulta;
    }
    public String recuperarEstado(int codigo) {
        String varConsulta = "SELECT anteproyecto.estado\n"
                + "from anteproyecto\n"
                + "where anteproyecto.codigoAnte = "+codigo+"";
        return varConsulta;
    }
       
     public String verificarCredenciales(String usuario, String contrasenia){
         String varConsulta = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?" ;
         return varConsulta;
     }
     public String obtenerTipoUsuario(int id){
         String varConsulta = "SELECT MIN(DISTINCT usuario_anteproyecto.rolAnte) FROM usuario_anteproyecto WHERE usuario_anteproyecto.identificacion = "+id+"";
         return varConsulta;
     }
     public String registrarUsuario(){
        String varConsulta = "INSERT INTO usuarios (identificacion, nombreApe, usuario, contraseña, rol) VALUES (?, ?, ?, ?, ?)";
        return varConsulta;
     }
     public String listarUsuarios(){
        String varConsulta = "SELECT * FROM usuarios";
        return varConsulta;
    }
     public String numeroDeFilas(){
        String varConsulta = "SELECT COUNT(*) FROM anteproyecto";
        return varConsulta;
    }
    public String numeroDeFilasUsuarios(){
        String varConsulta = "SELECT COUNT(*) FROM usuarios";
        return varConsulta;
    }
    public String asignarEvaluadores(){
        String varConsulta = "INSERT INTO tbl_evaluadores (CODIGO, EVALUADOR_1, CONCEPTO_EVALUADOR_1, FECHA_REVISION_1, EVALUADOR_2, CONCEPTO_EVALUADOR_2, FECHA_REVISION_2) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return varConsulta;
    }
    public String sacarConceptos(int codigo){
        String varConsulta = "SELECT concepto FROM usuario_anteproyecto WHERE codigoAnte = "+codigo+" AND rolAnte = 2";
        return varConsulta;
    }
    public String sacarConceptos2(int codigo){
        String varConsulta = "SELECT concepto FROM usuario_anteproyecto WHERE codigoAnte = "+codigo+" AND rolAnte = 2 ORDER BY identificacion ";
        return varConsulta;
    }
    public String listarEvaluadores(){
        String varConsulta = "SELECT * FROM tbl_evaluadores";
        return varConsulta;
    }
    public String numeroDeFilasEvaluadores(){
        String varConsulta = "SELECT COUNT(*) FROM tbl_evaluadores";
        return varConsulta;
    }
    public String verificarCodigoExistente(int codigo){
        String varConsulta = "SELECT CODIGO FROM tbl_evaluadores WHERE CODIGO = "+codigo+"";
        return varConsulta;
    }
    public String cambiarConceptoAnteproyecto(int codigo){
        String varConsulta = "UPDATE anteproyecto SET concepto = ? WHERE codigoAnte = "+codigo+"";
        return varConsulta;
    }
    public String actualizarEstado(){
        String varConsulta = "UPDATE anteproyecto SET estado = ? WHERE codigoAnte = ?";
        return varConsulta;
    }
     public String registrarUsuarioIngresado(){
        String varConsulta = "INSERT INTO tbl_historialUsuarios ( USUARIO_UNICAUCA, CONTRASENIA) VALUES (?, ?)";
        return varConsulta;
     }
     public String recuperarIdUsuario() {
        String varConsulta = "SELECT usuarios.identificacion\n"
                + "from usuarios\n"
                + "WHERE usuarios.usuario = (SELECT USUARIO_UNICAUCA FROM tbl_historialUsuarios ORDER BY ID DESC LIMIT 1)";
        return varConsulta;
    }
    public String verificarSiEsEvaluadorDelA(int codigo) {
        String varConsulta = "SELECT  usuario_anteproyecto.identificacion\n"
                + "from usuario_anteproyecto\n"
                + "where usuario_anteproyecto.identificacion =(SELECT usuarios.identificacion \n"
                + "from usuarios \n"
                + "where usuarios.usuario = (SELECT USUARIO_UNICAUCA FROM tbl_historialUsuarios ORDER BY ID DESC LIMIT 1))\n"
                + "AND usuario_anteproyecto.rolAnte = 2 AND usuario_anteproyecto.codigoAnte = " + codigo + "";
        return varConsulta;
    }

     
     
     public String recuperarNombresEvaluadores(int codigo){
        String varConsulta = "SELECT EVALUADOR_1, EVALUADOR_2 FROM tbl_evaluadores WHERE CODIGO = "+codigo+"";
        return varConsulta;
    }
      
    public String recuperarUsuarioEvaluador1(String nombre){
        String varConsulta = "SELECT USUARIO_UNICAUCA FROM tbl_usuarios WHERE NOMBRE_APE ="+"'"+nombre+"'";
        return varConsulta;
    }
    public String recuperarUsuarioEvaluador2(String nombre){
        String varConsulta = "SELECT USUARIO_UNICAUCA FROM tbl_usuarios WHERE NOMBRE_APE = "+"'"+nombre+"'";
        return varConsulta;
    }
     public String aniadirConceptoEvaluador(){
        String varConsulta = "UPDATE usuario_anteproyecto SET concepto = ? WHERE codigoAnte = ? AND identificacion = ? AND rolAnte = 2";
        return varConsulta;
    }
     
     public String verificarExistenciaDeUsuario(String usuario){
        String varConsulta =  "SELECT usuario FROM usuarios WHERE usuario = "+"'"+usuario+"'";
        return varConsulta;
    }
     public String verificarExistenciaDeIdentificacion(int id){
        String varConsulta =  "SELECT identificacion FROM usuarios WHERE identificacion = "+id+"";
        return varConsulta;
    }
    public String buscarEvaluadorAsignado(int codigo){
         String varConsulta = "SELECT * FROM tbl_evaluadores WHERE CODIGO = "+codigo+"";
         return varConsulta;
    }
//    public String prueba(){
//        String varConsulta = "SELECT tbl_usuarios.USUARIO_UNICAUCA FROM tbl_usuarios INNER JOIN tbl_evaluadores ON (tbl_usuarios.NOMBRE_APE=tbl_evaluadores.EVALUADOR_1) WHERE tbl_usuarios.NOMBRE_APE=tbl_evaluadores.EVALUADOR_1";
//        return varConsulta;
//    }
     

}
