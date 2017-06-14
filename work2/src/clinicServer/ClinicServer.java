package clinicServer;

import java.rmi.Naming;
import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import clinicClient.ClinicClient;
import clinicClient.ClinicInterface;
import lvlServer.LVLServer.ThreadS;
import record.*;
import java.net.*;
import clinic.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import clinic.*;

public class ClinicServer extends ClinicInterfacePOA implements ClinicInterface{
	
	HashMap <String,Record> recordA = new HashMap <String,Record>();
	HashMap <String,Record> recordB = new HashMap <String,Record>();
	HashMap <String,Record> recordC = new HashMap <String,Record>();
	HashMap <String,Record> recordD = new HashMap <String,Record>();
	HashMap <String,Record> recordE = new HashMap <String,Record>();
	HashMap <String,Record> recordF = new HashMap <String,Record>();
	HashMap <String,Record> recordG = new HashMap <String,Record>();
	HashMap <String,Record> recordH = new HashMap <String,Record>();
	HashMap <String,Record> recordI = new HashMap <String,Record>();
	HashMap <String,Record> recordJ = new HashMap <String,Record>();
	HashMap <String,Record> recordK = new HashMap <String,Record>();
	HashMap <String,Record> recordL = new HashMap <String,Record>();
	HashMap <String,Record> recordM = new HashMap <String,Record>();
	HashMap <String,Record> recordN = new HashMap <String,Record>();
	HashMap <String,Record> recordO = new HashMap <String,Record>();
	HashMap <String,Record> recordP = new HashMap <String,Record>();
	HashMap <String,Record> recordQ = new HashMap <String,Record>();
	HashMap <String,Record> recordR = new HashMap <String,Record>();
	HashMap <String,Record> recordS = new HashMap <String,Record>();
	HashMap <String,Record> recordT = new HashMap <String,Record>();
	HashMap <String,Record> recordU = new HashMap <String,Record>();
	HashMap <String,Record> recordV = new HashMap <String,Record>();
	HashMap <String,Record> recordW = new HashMap <String,Record>();
	HashMap <String,Record> recordX = new HashMap <String,Record>();
	HashMap <String,Record> recordY = new HashMap <String,Record>();
	HashMap <String,Record> recordZ = new HashMap <String,Record>();
	HashMap<String,HashMap <String,Record>> hashRecord = new HashMap<String,HashMap <String,Record>>();
	ArrayList<String> managerAllowID = new ArrayList<String>();
	String nowID;
	clinic.ClinicInterface service;
	private ORB orb;
	NamingContextExt ncRef;
	
	public ClinicServer() throws RemoteException{
		hashRecord.put("A", recordA);
		hashRecord.put("B", recordB);
		hashRecord.put("C", recordC);
		hashRecord.put("D", recordD);
		hashRecord.put("E", recordE);
		hashRecord.put("F", recordF);
		hashRecord.put("G", recordG);
		hashRecord.put("H", recordH);
		hashRecord.put("I", recordI);
		hashRecord.put("J", recordJ);
		hashRecord.put("K", recordK);
		hashRecord.put("L", recordL);
		hashRecord.put("M", recordM);
		hashRecord.put("N", recordN);
		hashRecord.put("O", recordO);
		hashRecord.put("P", recordP);
		hashRecord.put("Q", recordQ);
		hashRecord.put("R", recordR);
		hashRecord.put("S", recordS);
		hashRecord.put("T", recordT);
		hashRecord.put("U", recordU);
		hashRecord.put("V", recordV);
		hashRecord.put("W", recordW);
		hashRecord.put("X", recordX);
		hashRecord.put("Y", recordY);
		hashRecord.put("Z", recordZ);
		managerAllowID.add("DDO1000");
		
		///THIS IS A TEST
	}
	
	public int createDRecord(String managerID,String firstName,String lastName,String address,String phone,String specialization,String location){
		DoctorRecord d = new DoctorRecord(firstName,lastName,address,phone,specialization,location);
		HashMap <String,Record> recordTemp = hashRecord.get(""+lastName.charAt(0));
		synchronized(recordTemp){
			switch(""+lastName.charAt(0)){
			case "A":
				recordA.put(d.recordID,d);
				break;
			case "B":
				recordB.put(d.recordID,d);
				break;
			case "C":
				recordC.put(d.recordID,d);
				break;
			case "D":
				recordD.put(d.recordID,d);
				break;
			case "E":
				recordE.put(d.recordID,d);
				break;
			case "F":
				recordF.put(d.recordID,d);
				break;
			case "G":
				recordG.put(d.recordID,d);
				break;
			case "H":
				recordH.put(d.recordID,d);
				break;
			case "I":
				recordI.put(d.recordID,d);
				break;
			case "J":
				recordJ.put(d.recordID,d);
				break;
			case "K":
				recordK.put(d.recordID,d);
				break;
			case "L":
				recordL.put(d.recordID,d);
				break;
			case "M":
				recordM.put(d.recordID,d);
				break;
			case "N":
				recordN.put(d.recordID,d);
				break;
			case "O":
				recordO.put(d.recordID,d);
				break;
			case "P":
				recordP.put(d.recordID,d);
				break;
			case "Q":
				recordQ.put(d.recordID,d);
				break;
			case "R":
				recordR.put(d.recordID,d);
				break;
			case "S":
				recordS.put(d.recordID,d);
				break;
			case "T":
				recordT.put(d.recordID,d);
				break;
			case "U":
				recordU.put(d.recordID,d);
				break;
			case "V":
				recordV.put(d.recordID,d);
				break;
			case "W":
				recordW.put(d.recordID,d);
				break;
			case "X":
				recordX.put(d.recordID,d);
				break;
			case "Y":
				recordY.put(d.recordID,d);
				break;
			case "Z":
				recordZ.put(d.recordID,d);
				break;	
			}
			
		}
		
		Log.write(managerID + " create doctor record " + firstName + " " + lastName  + " " + address 
				 + " " + phone + " " + specialization + " " + location + " " + d.recordID, "DDOServer.txt");
		return 1;
	}
	
	public int createNRecord (String managerID,String firstName,String lastName,String designation,String status,String statusDate){
		NurseRecord n = new NurseRecord(firstName,lastName,designation,status,statusDate);
		HashMap <String,Record> recordTemp = hashRecord.get(""+lastName.charAt(0));
		synchronized(recordTemp){
		 switch(""+lastName.charAt(0)){
		 case "A":
				recordA.put(n.recordID,n);
				break;
			 case "B":
				recordB.put(n.recordID,n);
				break;
			 case "C":
				recordC.put(n.recordID,n);
				break;
			 case "D":
					recordD.put(n.recordID,n);
					break;
				case "E":
					recordE.put(n.recordID,n);
					break;
				case "F":
					recordF.put(n.recordID,n);
					break;
				case "G":
					recordG.put(n.recordID,n);
					break;
				case "H":
					recordH.put(n.recordID,n);
					break;
				case "I":
					recordI.put(n.recordID,n);
					break;
				case "J":
					recordJ.put(n.recordID,n);
					break;
				case "K":
					recordK.put(n.recordID,n);
					break;
				case "L":
					recordL.put(n.recordID,n);
					break;
				case "M":
					recordM.put(n.recordID,n);
					break;
				case "N":
					recordN.put(n.recordID,n);
					break;
				case "O":
					recordO.put(n.recordID,n);
					break;
				case "P":
					recordP.put(n.recordID,n);
					break;
				case "Q":
					recordQ.put(n.recordID,n);
					break;
				case "R":
					recordR.put(n.recordID,n);
					break;
				case "S":
					recordS.put(n.recordID,n);
					break;
				case "T":
					recordT.put(n.recordID,n);
					break;
				case "U":
					recordU.put(n.recordID,n);
					break;
				case "V":
					recordV.put(n.recordID,n);
					break;
				case "W":
					recordW.put(n.recordID,n);
					break;
				case "X":
					recordX.put(n.recordID,n);
					break;
				case "Y":
					recordY.put(n.recordID,n);
					break;
				case "Z":
					recordZ.put(n.recordID,n);
					break;
		 }
		}
		Log.write(managerID + " create nurse record " + firstName + " " + lastName  + " " + designation 
				 + " " + status + " " + statusDate + " " + n.recordID, "DDOServer.txt");
		return 1;
	}
	
	public int getRecordCounts (String recordType){
		
		int n = Record.num;
		return n;
	}
	
	public int verifyManagerID (String id){
		
		Log.write(id + " connect to DDO ", "DDOServer.txt");
		if(managerAllowID.contains(id)){
			Log.write(id + " accept ", "DDOServer.txt");
			nowID = id;
			return 1;
		}else{
			Log.write(id + " reject ", "DDOServer.txt");
			return 0;
		}
			
	}
	
public class ThreadS implements Runnable{
		
		DatagramPacket request;
		DatagramSocket aSocket;
		
		public ThreadS(DatagramSocket aSocket,DatagramPacket request){
			this.request = request;
			this.aSocket = aSocket;
		}
		
		public void run(){
			try{
						String num = ""+Record.num;
						byte[] m = num.getBytes();
						DatagramPacket reply = new DatagramPacket(m,m.length,request.getAddress(),request.getPort());
						aSocket.send(reply);
						Log.write(" reply a Count request ", "DDOServer.txt");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
public void receive(){
	
	DatagramSocket aSocket = null;
	try{
		aSocket = new DatagramSocket(5003);
		byte[] buffer = new byte[1000];
		while(true){
			DatagramPacket request = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(request);
			Thread t = new Thread(new ThreadS(aSocket, request));
			t.start();
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		if(aSocket != null){
			aSocket.close();
	}
	}

}
	
	public int editRecord (String managerID,String ID,String fieldName,String newValue){
		
		Log.write(managerID + " edit record " + ID + " " + fieldName  + " " + newValue , "DDOServer.txt");
		Record r = searchID(ID);
		if(r == null){
			Log.write(managerID + " edit record fail", "DDOServer.txt");
			System.out.println("nullll");
			return 0;
		}
		synchronized(r){
			if(r.type.equals("DR")){
				DoctorRecord dr = (DoctorRecord)r;
				if(fieldName.equals("address")){
					dr.address = newValue;
				}
				else if(fieldName.equals("phone")){
					dr.phone = newValue;
				}
				else if(fieldName.equals("location")){
					dr.location = newValue;
				}
				else{
					Log.write(managerID + " edit record fail", "DDOServer.txt");
					return 0;
				}
					
			}
			else{
				NurseRecord nr = (NurseRecord)r;
				if(fieldName.equals("designation")){
					nr.designation = newValue;
				}
				else if(fieldName.equals("status")){
					nr.status = newValue;
				}
				else if(fieldName.equals("statusDate")){
					nr.statusDate = newValue;
				}
				else{
					Log.write(managerID + " edit record fail", "DDOServer.txt");
					return 0;
				}
			}
			Log.write(managerID + " edit record success", "DDOServer.txt");
		}
		return 1;
	}
	
	public Record searchID(String ID){

		Iterator iter = hashRecord.keySet().iterator();
		while (iter.hasNext()) {
		String key = (String)iter.next();
		HashMap <String,Record> rec = hashRecord.get(key);
		if(rec.containsKey(ID)){
			return rec.get(ID);
		}
		}
		return null;
	}
	
	public int transferRecord (String managerID,String ID,String remoteName){
		Record r = searchID(ID);
		if(r == null){
			System.out.println("No this ID");
			return 0;
		}
		HashMap <String,Record> recordTemp = hashRecord.get(""+r.lastName.charAt(0));
		try{
				if(remoteName.equals("MTL")){
					service = ClinicInterfaceHelper.narrow(ncRef.resolve_str("MTL"));
					Log.write("transfer to MTL ", "DDOServer.txt");
					Log.write("transfer from DDO ", "MTLServer.txt");
				}else if(remoteName.equals("LVL")){
					service = ClinicInterfaceHelper.narrow(ncRef.resolve_str("LVL"));
					Log.write("transfer to LVL ", "DDOServer.txt");
					Log.write("transfer from DDO ", "LVLServer.txt");
				}else if(remoteName.equals("DDO")){
					service = ClinicInterfaceHelper.narrow(ncRef.resolve_str("DDO"));
					Log.write("transfer to DDO ", "DDOServer.txt");
					Log.write("transfer from DDO ", "DDOServer.txt");
				}else{
					System.out.println("remoteName error");
					Log.write("wrong remoteName", "DDOServer.txt");
					return 0;
				}
				if(ID.substring(0, 2).equals("DR")){
					DoctorRecord d = (DoctorRecord)r;
					int success = 0;
					synchronized(d){
						success = service.createDRecord(managerID,d.firstName,d.lastName,d.address,d.phone,d.specialization,d.location); 
						}
					if(success == 1){
						System.out.println("create successfully");
						Log.write(managerID + " create doctor record success", "DDOServer.txt");
						synchronized(recordTemp){
							recordTemp.remove(ID);
							}
						d.numdecre();
					}
					else{
						System.out.println("create error");
						Log.write(managerID + " create doctor record fail", "DDOServer.txt");
					}
				}else{
					NurseRecord n = (NurseRecord)r;
					int success = 0;
					synchronized(n){
						success = service.createNRecord(managerID,n.firstName,n.lastName,n.designation,n.status,n.statusDate); 
						}
					if(success == 1){
						System.out.println("create successfully");
						Log.write(managerID + " create nurse record success", "DDOServer.txt");
						synchronized(recordTemp){
							recordTemp.remove(ID);
							}
						n.numdecre();
					}
					else{
						System.out.println("create error");
						Log.write(managerID + " create nurse record fail", "DDOServer.txt");
					}
			        }
		     
		}catch(Exception e){
			e.printStackTrace();
		}
		return 1;
	}
	
	public void setORB(ORB orb_val) {
		orb = orb_val;
		}

	public static void main(String[] args) {
		try{
			ClinicServer server = new ClinicServer();
			new Thread(new Runnable(){public void run(){server.receive();}}).start();
			Properties props = new Properties();
		    props.put("org.omg.CORBA.ORBInitialPort", "1050");    
		    props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1"); 
		    ORB orb = ORB.init(args, props);
			POA rootpoa =(POA)orb.resolve_initial_references("RootPOA");
			rootpoa.the_POAManager().activate();
			server.setORB(orb);
			org.omg.CORBA.Object ref =rootpoa.servant_to_reference(server);
			clinic.ClinicInterface href = ClinicInterfaceHelper.narrow(ref);
			Log.write("Server start", "DDOServer.txt");
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			server.ncRef = NamingContextExtHelper.narrow(objRef);
			String name = "DDO";
			NameComponent path[] = server.ncRef.to_name( name );
			server.ncRef.rebind(path, href);
			System.out.println("Server ready and waiting ...");
			orb.run();
			
		} catch(Exception ex){
			ex.printStackTrace();
		}

	}

}