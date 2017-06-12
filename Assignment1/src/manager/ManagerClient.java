package manager;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import record.Log;

public class ManagerClient {
	
	static ArrayList<String> managerList = new ArrayList<String>();

	
	CenterServerInterface service;
	String managerID;
	String managerFilePath = "LogManager/";

	
	/**
	 * Constructor based on the managerID of manager.
	 * @param managerID
	 * @throws RemoteException
	 */
	public ManagerClient(String managerID) throws RemoteException {
		
		if(managerList.contains(managerID)) {
			System.out.println(managerID + "Welcome back to manager system.");
			Log.write(managerID + " Log in.", managerFilePath);
		} else {
			managerList.add(managerID);
			System.out.println(managerID + "New user");
			Log.write(managerID + " Log in.", managerFilePath);
			
		}
		
		this.managerID = managerID;
		managerFilePath = managerFilePath + managerID + ".txt";
		
		while(true) {
			menu();
		}
		
	}
	
	/**
	 * the main menu of operations.
	 */
	public void menu() {
		try {
			connect();
		} catch (Exception e) {
			
		}
		
		System.out.println("The Manager System\n");
		System.out.println("1.Create Teacher Record");
		System.out.println("2.Create Student Record");
		System.out.println("3.Count of Record");
		System.out.println("4.Edit exist Record");
		
		Scanner in = new Scanner(System.in);
		String a = "";
		a = in.nextLine();

		switch(a) {
		case "1" : createTeacherRecord();break;
		case "2" : createStudentRecord();break;
		case "3" : getCount();break;
		case "4" : recordEdit();break;
		default: System.out.println("Invalid input.\n");
		}

	}
	
	/**
	 * bind the port of the server via RMI
	 * @throws Exception
	 */
	public boolean connect() throws Exception{
		
		System.out.println(managerID + "Connecting...");
		
		String server = managerID.substring(0, 3);

		if(server.equals("MTL")) {
			service = (CenterServerInterface) Naming.lookup("rmi://localhost:5100/test");
			Log.write("Connect to MTL successful", managerFilePath);
		} else if(server.equals("LVL")) {
			service = (CenterServerInterface) Naming.lookup("rmi://localhost:5101/test");
			Log.write("Connect to LVL successful", managerFilePath);
		} else if(server.equals("DDO")) {
			service = (CenterServerInterface) Naming.lookup("rmi://localhost:5102/test");
			Log.write("Connect to DDO successful", managerFilePath);
		} else {
			System.out.println("Invalid managerID");
			return false;
		}
		return true;	
	}
	

	/**
	 * show the total count of each server.
	 */
	public void getCount(){	
		try {
			System.out.println(service.getRecordCounts());
		} catch (RemoteException e) {
			
		}
	}
	
	/**
	 * create teacher record by call the server's createTRecord method via RMI
	 */
	public void createTeacherRecord() {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter: firstName");
		String firstName = in.next();
		System.out.println("Please enter: lastName");
		String lastName = in.next();
		System.out.println("Please enter: address");
		String address = in.next();
		System.out.println("Please enter: phone");
		String phone = in.next();
		System.out.println("Please enter: specialization");
		String specialization = in.next();
		System.out.println("Please enter: location");
		String location = in.next();
		if(!location.equals("DDO")&&!location.equals("LVL")&&!location.equals("MTL"))
		{
			System.out.println("Wrong location, please select again!");
			return;
		}

		Log.write(managerID + "\t\tCreate Teacher Record :   " + "\n" + firstName 
				+ "   " + lastName + "   " + address + "   " + phone + "   " + specialization 
				+ "   " + location, managerFilePath);
		
		try {
			if(service.createTRecord(managerID, firstName, lastName, address, phone, 
					specialization, location)) {
				System.out.println("Create success.");
				Log.write(managerID + "\t\tCreate Teacher Record successful", managerFilePath);
			} else {
				System.out.println("Create fail.");
				Log.write(managerID + "\t\tCreate Teacher Record fail", managerFilePath);
			}
		} catch (RemoteException e) {
			
		}
			
	}
	
	/**
	 * create student record by call the server's createSRecord method via RMI
	 */
	public void createStudentRecord() {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter: firstName");
		String firstName = in.next();
		System.out.println("Please enter: lastName");
		String lastName = in.next();
		System.out.println("Please enter: courseRegistered");
		String courseRegistered = in.next();
		System.out.println("Please enter: status");
		String status = in.next();
		System.out.println("Please enter: statusDate");
		String statusDate = in.next();
		
		//in.close();
		
		Log.write(managerID + "\t\tCreate Student Record :   " + "\n" + firstName 
				+ "   " + lastName + "   " + courseRegistered + "   " + status + "   " 
				+ statusDate , managerFilePath);
		
		try {
			if(service.createSRecord(managerID, firstName, lastName, courseRegistered, 
					status, statusDate)) {
				System.out.println("Create success.");
				Log.write(managerID + "\t\tCreate Student Record successful", managerFilePath);
			} else {
				System.out.println("Create fail.");
				Log.write(managerID + "\t\tCreate Student Record fail", managerFilePath);
			}
		} catch (RemoteException e) {
			
		}	
	}
	
	/**
	 * edit record by call the server's editRecord method via RMI
	 */
	public void recordEdit() {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter: recordID");
		String recordID = in.next();
		System.out.println("Please enter: fieldName");
		String fieldName = in.next();
		System.out.println("Please enter: newValue");
		String newValue = in.next();	
		if(fieldName.equals("location")&&!newValue.equals("DDO")&&!newValue.equals("LVL")&&!newValue.equals("MTL"))
		{
			System.out.println("Wrong location!!");
			return;
		}
		
		
		//in.close();

		Log.write(managerID + "---Record edit---" + recordID + " " + fieldName 
				+ " " + newValue , managerFilePath);

		try {
			if(service.editRecord(managerID, recordID, fieldName, newValue)) {
				System.out.println("Edit success.");
				Log.write(managerID + "---Record edit success---" + recordID + "\n" + fieldName + 
						" : " + newValue , managerFilePath);
			} else {
				System.out.println("Edit fail.");
				Log.write(managerID + "---Record edit fail---" + recordID + "\n" + fieldName + 
						" : " + newValue , managerFilePath);
			}
		} catch (RemoteException e) {
			
		}	
	}
	
}
