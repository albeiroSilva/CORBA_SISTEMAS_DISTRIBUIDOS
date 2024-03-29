package sop_corba.GestionAnteproyectosPackage;


/**
* sop_corba/GestionAnteproyectosPackage/evaluadoresDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interfaz.idl
* martes 30 de julio de 2019 20H58' COT
*/

abstract public class evaluadoresDTOHelper
{
  private static String  _id = "IDL:sop_corba/GestionAnteproyectos/evaluadoresDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, sop_corba.GestionAnteproyectosPackage.evaluadoresDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static sop_corba.GestionAnteproyectosPackage.evaluadoresDTO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [7];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "codigo",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "evaluador_1",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "conceptoEvaluador_1",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "fechaRevision_1",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "evaluador_2",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "conceptoEvaluador_2",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "fechaRevision_2",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (sop_corba.GestionAnteproyectosPackage.evaluadoresDTOHelper.id (), "evaluadoresDTO", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static sop_corba.GestionAnteproyectosPackage.evaluadoresDTO read (org.omg.CORBA.portable.InputStream istream)
  {
    sop_corba.GestionAnteproyectosPackage.evaluadoresDTO value = new sop_corba.GestionAnteproyectosPackage.evaluadoresDTO ();
    value.codigo = istream.read_long ();
    value.evaluador_1 = istream.read_string ();
    value.conceptoEvaluador_1 = istream.read_string ();
    value.fechaRevision_1 = istream.read_string ();
    value.evaluador_2 = istream.read_string ();
    value.conceptoEvaluador_2 = istream.read_string ();
    value.fechaRevision_2 = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, sop_corba.GestionAnteproyectosPackage.evaluadoresDTO value)
  {
    ostream.write_long (value.codigo);
    ostream.write_string (value.evaluador_1);
    ostream.write_string (value.conceptoEvaluador_1);
    ostream.write_string (value.fechaRevision_1);
    ostream.write_string (value.evaluador_2);
    ostream.write_string (value.conceptoEvaluador_2);
    ostream.write_string (value.fechaRevision_2);
  }

}
