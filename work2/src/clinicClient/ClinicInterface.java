package clinicClient;

import java.rmi.*;

public interface ClinicInterface extends Remote{
	
	public int createDRecord(String managerID,String firstName,String lastName,String address,String phone,String specialization,String location)
	        throws RemoteException;
	
	public int createNRecord (String managerID,String firstName,String lastName,String designation,String status,String statusDate)
			throws RemoteException;
	
	public int verifyManagerID (String id)
			throws RemoteException;
	
	public int editRecord (String managerID,String recordID,String fieldName,String newValue)
			throws RemoteException;
	
	public int transferRecord (String managerID,String ID,String remoteName)
			throws RemoteException;

}
