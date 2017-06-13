package clinic;


/**
* clinic/ClinicInterfaceOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��C:/Users/k2ggg/workspace/CORBA/src/clinicClient/clinic.idl
* 2016��7��3�� ������ ����11ʱ45��54�� EDT
*/

public interface ClinicInterfaceOperations 
{
  int createDRecord (String managerID, String firstName, String lastName, String address, String phone, String specialization, String location);
  int createNRecord (String managerID, String firstName, String lastName, String designation, String status, String statusDate);
  int verifyManagerID (String id);
  int editRecord (String managerID, String recordID, String fieldName, String newValue);
  int transferRecord (String managerID, String ID, String remoteName);
} // interface ClinicInterfaceOperations
