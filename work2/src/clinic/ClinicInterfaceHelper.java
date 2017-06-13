package clinic;


/**
* clinic/ClinicInterfaceHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从C:/Users/k2ggg/workspace/CORBA/src/clinicClient/clinic.idl
* 2016年7月3日 星期日 下午11时45分54秒 EDT
*/

abstract public class ClinicInterfaceHelper
{
  private static String  _id = "IDL:clinic/ClinicInterface:1.0";

  public static void insert (org.omg.CORBA.Any a, clinic.ClinicInterface that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static clinic.ClinicInterface extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (clinic.ClinicInterfaceHelper.id (), "ClinicInterface");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static clinic.ClinicInterface read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ClinicInterfaceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, clinic.ClinicInterface value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static clinic.ClinicInterface narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof clinic.ClinicInterface)
      return (clinic.ClinicInterface)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      clinic._ClinicInterfaceStub stub = new clinic._ClinicInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static clinic.ClinicInterface unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof clinic.ClinicInterface)
      return (clinic.ClinicInterface)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      clinic._ClinicInterfaceStub stub = new clinic._ClinicInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
