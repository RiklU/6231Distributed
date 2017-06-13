package clinic;


/**
* clinic/ClinicInterfacePOA.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从C:/Users/k2ggg/workspace/CORBA/src/clinicClient/clinic.idl
* 2016年7月3日 星期日 下午11时45分54秒 EDT
*/

public abstract class ClinicInterfacePOA extends org.omg.PortableServer.Servant
 implements clinic.ClinicInterfaceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("createDRecord", new java.lang.Integer (0));
    _methods.put ("createNRecord", new java.lang.Integer (1));
    _methods.put ("verifyManagerID", new java.lang.Integer (2));
    _methods.put ("editRecord", new java.lang.Integer (3));
    _methods.put ("transferRecord", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // clinic/ClinicInterface/createDRecord
       {
         String managerID = in.read_string ();
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         String address = in.read_string ();
         String phone = in.read_string ();
         String specialization = in.read_string ();
         String location = in.read_string ();
         int $result = (int)0;
         $result = this.createDRecord (managerID, firstName, lastName, address, phone, specialization, location);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // clinic/ClinicInterface/createNRecord
       {
         String managerID = in.read_string ();
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         String designation = in.read_string ();
         String status = in.read_string ();
         String statusDate = in.read_string ();
         int $result = (int)0;
         $result = this.createNRecord (managerID, firstName, lastName, designation, status, statusDate);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // clinic/ClinicInterface/verifyManagerID
       {
         String id = in.read_string ();
         int $result = (int)0;
         $result = this.verifyManagerID (id);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 3:  // clinic/ClinicInterface/editRecord
       {
         String managerID = in.read_string ();
         String recordID = in.read_string ();
         String fieldName = in.read_string ();
         String newValue = in.read_string ();
         int $result = (int)0;
         $result = this.editRecord (managerID, recordID, fieldName, newValue);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 4:  // clinic/ClinicInterface/transferRecord
       {
         String managerID = in.read_string ();
         String ID = in.read_string ();
         String remoteName = in.read_string ();
         int $result = (int)0;
         $result = this.transferRecord (managerID, ID, remoteName);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:clinic/ClinicInterface:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ClinicInterface _this() 
  {
    return ClinicInterfaceHelper.narrow(
    super._this_object());
  }

  public ClinicInterface _this(org.omg.CORBA.ORB orb) 
  {
    return ClinicInterfaceHelper.narrow(
    super._this_object(orb));
  }


} // class ClinicInterfacePOA
