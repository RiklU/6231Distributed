package clinicClient;

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.net.*;

import record.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import clinic.*;


public class ClinicClient {
	
	ArrayList <Record> recordA = new ArrayList <Record>();
	ArrayList <Record> recordB = new ArrayList <Record>();
	ArrayList <Record> recordC = new ArrayList <Record>();
	HashMap<String,ArrayList <Record>> hashRecord = new HashMap<String,ArrayList <Record>>();
	clinic.ClinicInterface service;
	NamingContextExt ncRef;
	Scanner reader;
	String managerID;
	String managerLog;
	int server;
	
	public ClinicClient() throws RemoteException{
		
		hashRecord.put("A", recordA);
		hashRecord.put("B", recordB);
		hashRecord.put("C", recordC);
	}
	
	public static void  showMenu(){
		System.out.println("insert what u want to do");
		System.out.println("1.createDRecord");
		System.out.println("2.createNRecord");
		System.out.println("3.getRecordCounts");
		System.out.println("4.editRecord");
		System.out.println("5.transferRecord");
	}
	
	
	public int verify() throws Exception{
		
		Log.write("client start", "client.txt");
		System.out.println("insert ur id");
		managerID = reader.nextLine();
		System.out.println(managerID.substring(0, 3));
		Log.write("insert manageID " + managerID, "client.txt");
		if(managerID.substring(0, 3).equals("MTL")){
			service = ClinicInterfaceHelper.narrow(ncRef.resolve_str("MTL"));
			Log.write("connect to MTL ", "client.txt");
		}else if(managerID.substring(0, 3).equals("LVL")){
			service = ClinicInterfaceHelper.narrow(ncRef.resolve_str("LVL"));
			Log.write("connect to LVL ", "client.txt");
		}else if(managerID.substring(0, 3).equals("DDO")){
			service = ClinicInterfaceHelper.narrow(ncRef.resolve_str("DDO"));
			Log.write("connect to DDO ", "client.txt");
		}else{
			System.out.println("ID error");
			Log.write("wrong id", "client.txt");
			return 0;
		}
		if(service.verifyManagerID (managerID) == 1){
			System.out.println("login successfully");
			Log.write("connect success right id", "client.txt");
			return 1;
		}
		else{
			System.out.println("login error");
			Log.write("connect fail wrong id", "client.txt");
			return 0;
		}
		
	}
	
	public void createD() throws RemoteException{
		
		System.out.println("Please enter: String firstName,String lastName,String address,String phone,String specialization,String location");
		String firstName = reader.next();
		String lastName = reader.next();
		String address = reader.next();
		String phone = reader.next();
		String specialization = reader.next();
		String location = reader.next();
		Log.write(managerID + " create doctor record " + firstName + " " + lastName  + " " + address 
				 + " " + phone + " " + specialization + " " + location, "client.txt");
		Log.write(managerID + " create doctor record " + firstName + " " + lastName  + " " + address 
				 + " " + phone + " " + specialization + " " + location, managerLog);
		new Thread(new Runnable(){public void run(){
			if(service.createDRecord(managerID,firstName,lastName,address,phone,specialization,location) == 1){
				System.out.println("create successfully");
				Log.write(managerID + " create doctor record success", "client.txt");
				Log.write(managerID + " create doctor record success", managerLog);
			}
			else{
				System.out.println("create error");
				Log.write(managerID + " create doctor record fail", "client.txt");
				Log.write(managerID + " create doctor record fail", managerLog);
			}
		}}).start();
	}
	
	public void createN() throws RemoteException{
		
		System.out.println("String firstName,String lastName,String designation,String status,String statusDate");
		String firstName = reader.next();
		String lastName = reader.next();
		String designation = reader.next();
		String status = reader.next();
		String statusDate = reader.next();
		Log.write(managerID + " create doctor record " + firstName + " " + lastName  + " " + designation 
				 + " " + status + " " + statusDate, "client.txt");
		Log.write(managerID + " create doctor record " + firstName + " " + lastName  + " " + designation 
				 + " " + status + " " + statusDate, managerLog);
		new Thread(new Runnable(){public void run(){
		if(service.createNRecord(managerID,firstName,lastName,designation,status,statusDate) == 1){
			System.out.println("create successfully");
			Log.write(managerID + " create nurse record success", "client.txt");
			Log.write(managerID + " create nurse record success", managerLog);
		}
		else{
			System.out.println("create error");
			Log.write(managerID + " create nurse record fail", "client.txt");
			Log.write(managerID + " create nurse record fail", managerLog);
		}
		}}).start();
		
	}
	
	public void getCount(){
		DatagramSocket mySocket = null;
		try{
			mySocket = new DatagramSocket();
			String num = ""+Record.num;
			byte[] m = "request".getBytes();
			InetAddress host = InetAddress.getByName("localhost");
			int mtlPort = 5001;
			int lvlPort = 5002;
			int ddoPort = 5003;
			DatagramPacket request = new DatagramPacket(m,"request".length(),host,mtlPort);
			mySocket.send(request);
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			mySocket.receive(reply);
			String result1 = "MTL: " + new String(reply.getData());
			System.out.println(result1);
			request = new DatagramPacket(m,"request".length(),host,lvlPort);
			mySocket.send(request);
			buffer = new byte[1000];
			reply = new DatagramPacket(buffer, buffer.length);
			mySocket.receive(reply);
			String result2 = "LVL: " + new String(reply.getData());
			System.out.println(result2);
			request = new DatagramPacket(m,"request".length(),host,ddoPort);
			mySocket.send(request);
			buffer = new byte[1000];
			reply = new DatagramPacket(buffer, buffer.length);
			mySocket.receive(reply);
			String result3 = "DDO: " + new String(reply.getData());
			System.out.println(result3);
			Log.write(managerID + " send Count request to all clinic", "client.txt");
			Log.write(managerID + " send Count request to all clinic", managerLog);
			Log.write(managerID + " get Count result to all clinic " 
			+ result1 + " " + result2  + " " + result3, "client.txt");
			Log.write(managerID + " send Count request to all clinic " 
			+ result1 + " " + result2  + " " + result3, managerLog);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(mySocket != null){
				mySocket.close();
			}
		}
	}
		
	
	public void editRecord() throws RemoteException{
		
		System.out.println("String recordID,String fieldName,String newValue");
		String recordID = reader.next();
		String fieldName = reader.next();
		String newValue = reader.next();
		Log.write(managerID + " edit record " + recordID + " " + fieldName  + " " + newValue , "client.txt");
		Log.write(managerID + " edit record " + recordID + " " + fieldName  + " " + newValue , managerLog);
		new Thread(new Runnable(){public void run(){
		if(service.editRecord(managerID,recordID,fieldName,newValue) == 1){
			System.out.println("edit successfully");
			Log.write(managerID + " edit record success", "client.txt");
			Log.write(managerID + " edit record success", managerLog);
		}
		else{
			System.out.println("edit error");
			Log.write(managerID + " edit record fail", "client.txt");
			Log.write(managerID + " edit record fail", managerLog);
		}
		}}).start();
			
	}
	
public void transferRecord() throws RemoteException{
		
		System.out.println("String ID,String remoteName");
		String ID = reader.next();
		String remoteName = reader.next();
		Log.write(managerID + " edit record " + ID + " " + remoteName , "client.txt");
		Log.write(managerID + " edit record " + ID + " " + remoteName , managerLog);
		new Thread(new Runnable(){public void run(){
		if(service.transferRecord (managerID,ID,remoteName) == 1){
			System.out.println("transfer successfully");
			Log.write(managerID + " transfer record success", "client.txt");
			Log.write(managerID + " transfer record success", managerLog);
		}
		else{
			System.out.println("transfer error");
			Log.write(managerID + " transfer record fail", "client.txt");
			Log.write(managerID + " transfer record fail", managerLog);
		}
		}}).start();
			
	}
	
	public void go() throws Exception{
		
		managerLog = managerID + ".txt";
		showMenu();
		String re = reader.nextLine();
		switch(""+re){
		case "1":
			createD();
			break;
		case "2":
			createN();
			break;
		case "3":
			new Thread(new Runnable(){public void run(){getCount();}}).start();
			break;
		case "4":
			editRecord();
			break;
		case "5":
			transferRecord();
			break;
		}
	}

	public static void main(String[] args) {
		
		try{
			ClinicClient clinic = new ClinicClient();
			Properties props = new Properties();
		    props.put("org.omg.CORBA.ORBInitialPort", "1050");    
		    props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1"); 
		    ORB orb = ORB.init(args, props);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			clinic.ncRef = NamingContextExtHelper.narrow(objRef);
			clinic.reader = new Scanner(System.in);
			while(clinic.verify()!=1){};
			while(true){
			clinic.go();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}	

	}

}
