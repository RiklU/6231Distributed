package clinic;

/**
* clinic/ClinicInterfaceHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��C:/Users/k2ggg/workspace/CORBA/src/clinicClient/clinic.idl
* 2016��7��3�� ������ ����11ʱ45��54�� EDT
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
