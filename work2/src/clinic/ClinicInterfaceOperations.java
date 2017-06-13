package clinic;


/**
* clinic/ClinicInterfaceOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从C:/Users/k2ggg/workspace/CORBA/src/clinicClient/clinic.idl
* 2016年7月3日 星期日 下午11时45分54秒 EDT
*/

public interface ClinicInterfaceOperations 
{
  int createDRecord (String managerID, String firstName, String lastName, String address, String phone, String specialization, String location);
  int createNRecord (String managerID, String firstName, String lastName, String designation, String status, String statusDate);
  int verifyManagerID (String id);
  int editRecord (String managerID, String recordID, String fieldName, String newValue);
  int transferRecord (String managerID, String ID, String remoteName);
} // interface ClinicInterfaceOperations
