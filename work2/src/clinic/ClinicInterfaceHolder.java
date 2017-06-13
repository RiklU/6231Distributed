package clinic;

/**
* clinic/ClinicInterfaceHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从C:/Users/k2ggg/workspace/CORBA/src/clinicClient/clinic.idl
* 2016年7月3日 星期日 下午11时45分54秒 EDT
*/

public final class ClinicInterfaceHolder implements org.omg.CORBA.portable.Streamable
{
  public clinic.ClinicInterface value = null;

  public ClinicInterfaceHolder ()
  {
  }

  public ClinicInterfaceHolder (clinic.ClinicInterface initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = clinic.ClinicInterfaceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    clinic.ClinicInterfaceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return clinic.ClinicInterfaceHelper.type ();
  }

}
