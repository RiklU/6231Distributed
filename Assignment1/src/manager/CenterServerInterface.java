package manager;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CenterServerInterface extends Remote{
	
	public boolean createTRecord(String managerID, String firstName, String lastName, String address, String phone, String specialization, String location)
	        throws RemoteException;
	
	public boolean createSRecord (String managerID, String firstName, String lastName,String courseRegistered, String status, String statusDate)
			throws RemoteException;
	
	public String getRecordCounts ()
			throws RemoteException;

	public boolean editRecord (String managerID, String recordID, String fieldName, String newValue)
			throws RemoteException;
	
}