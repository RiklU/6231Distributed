package manager;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import record.Log;
import record.Record;
import record.StudentRecord;
import record.TeacherRecord;

public class CenterServer extends UnicastRemoteObject implements CenterServerInterface, Runnable {
	
	private static final long serialVersionUID = 1L;
	
	HashMap <String, Record> recordA = new HashMap <String, Record>();
	HashMap <String, Record> recordB = new HashMap <String, Record>();
	HashMap <String, Record> recordC = new HashMap <String, Record>();
	HashMap <String, Record> recordD = new HashMap <String, Record>();
	HashMap <String, Record> recordE = new HashMap <String, Record>();
	HashMap <String, Record> recordF = new HashMap <String, Record>();
	HashMap <String, Record> recordG = new HashMap <String, Record>();
	HashMap <String, Record> recordH = new HashMap <String, Record>();
	HashMap <String, Record> recordI = new HashMap <String, Record>();
	HashMap <String, Record> recordJ = new HashMap <String, Record>();
	HashMap <String, Record> recordK = new HashMap <String, Record>();
	HashMap <String, Record> recordL = new HashMap <String, Record>();
	HashMap <String, Record> recordM = new HashMap <String, Record>();
	HashMap <String, Record> recordN = new HashMap <String, Record>();
	HashMap <String, Record> recordO = new HashMap <String, Record>();
	HashMap <String, Record> recordP = new HashMap <String, Record>();
	HashMap <String, Record> recordQ = new HashMap <String, Record>();
	HashMap <String, Record> recordR = new HashMap <String, Record>();
	HashMap <String, Record> recordS = new HashMap <String, Record>();
	HashMap <String, Record> recordT = new HashMap <String, Record>();
	HashMap <String, Record> recordU = new HashMap <String, Record>();
	HashMap <String, Record> recordV = new HashMap <String, Record>();
	HashMap <String, Record> recordW = new HashMap <String, Record>();
	HashMap <String, Record> recordX = new HashMap <String, Record>();
	HashMap <String, Record> recordY = new HashMap <String, Record>();
	HashMap <String, Record> recordZ = new HashMap <String, Record>();
	
	HashMap <Character, HashMap <String, Record>> Records =new HashMap<Character, HashMap <String, Record>>();
	String serverType;
	String serverFilePath = "LogServer/";
	
	int countTotal;
	int countOfTeacher;
	int countOfStudent;
	
	/**
	 * Constructor based on the type of server.
	 * @param serverType
	 * @throws RemoteException
	 */
	public CenterServer(String serverType) throws RemoteException{
		
		Records.put('A', recordA);
		Records.put('B', recordB);
		Records.put('C', recordC);
		Records.put('D', recordD);
		Records.put('E', recordE);
		Records.put('F', recordF);
		Records.put('G', recordG);
		Records.put('H', recordH);
		Records.put('I', recordI);
		Records.put('J', recordJ);
		Records.put('K', recordK);
		Records.put('L', recordL);
		Records.put('M', recordM);
		Records.put('N', recordN);
		Records.put('O', recordO);
		Records.put('P', recordP);
		Records.put('Q', recordQ);
		Records.put('R', recordR);
		Records.put('S', recordS);
		Records.put('T', recordT);
		Records.put('U', recordU);
		Records.put('V', recordV);
		Records.put('W', recordW);
		Records.put('X', recordX);
		Records.put('Y', recordY);
		Records.put('Z', recordZ);

		this.serverType = serverType;
		serverFilePath = serverFilePath + serverType + "Server.txt";
		
		countTotal = 0;
		countOfTeacher = 0;
		countOfStudent = 0;
		
	}
	
	/**
	 * synchronized method for add the count of teacher.
	 */
	private synchronized void increaseTeacherCount() {
		countTotal++;
		countOfTeacher++;
	}
	
	/**
	 * synchronized method for add the count of student.
	 */
	private synchronized void increaseStudentCount() {
		countTotal++;
		countOfStudent++;
	}
	
	/**
	 * override for multiply threads.
	 * the method get request from manager based on RMI and return the count through UDP.
	 */
	@Override
	public void run() {
		
		DatagramSocket UDPSocket = null;
		
		try {	
			switch(serverType) {
			case "MTL": UDPSocket = new DatagramSocket(4001);break;
			case "LVL": UDPSocket = new DatagramSocket(4002);break;
			case "DDO": UDPSocket = new DatagramSocket(4003);break;
			}

			byte[] sendBuffer = new byte[1000];
			
			
			byte[] receiveBuffer = new byte[1000];

			
			while(true) {
				DatagramPacket request = new DatagramPacket(receiveBuffer, receiveBuffer.length);
				UDPSocket.receive(request);
				String countOfServer = String.valueOf(countTotal);
				System.out.println(countOfServer);
				sendBuffer = countOfServer.getBytes();
				DatagramPacket reply = new DatagramPacket(sendBuffer, sendBuffer.length, 
						request.getAddress(),request.getPort());
				UDPSocket.send(reply);
			}	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(UDPSocket != null)
				UDPSocket.close();
		}
	}

	/**
	 * create teacher record in this server.
	 */
	@Override
	public synchronized boolean createTRecord(String managerID, String firstName, String lastName, String address, String phone,
			String specialization, String location) throws RemoteException {
		
		TeacherRecord teacherRecord = new TeacherRecord(firstName, lastName, address, phone, 
				specialization, location);
		String RecordID = "TR" + String.valueOf(10001 + countOfTeacher);
		
		switch(lastName.charAt(0)) {
		
		case 'A':
			recordA.put(RecordID, teacherRecord);
			break;
		case 'B':
			recordB.put(RecordID, teacherRecord);
			break;
		case 'C':
			recordC.put(RecordID, teacherRecord);
			break;
		case 'D':
			recordD.put(RecordID, teacherRecord);
			break;
		case 'E':
			recordE.put(RecordID, teacherRecord);
			break;
		case 'F':
			recordF.put(RecordID, teacherRecord);
			break;
		case 'G':
			recordG.put(RecordID, teacherRecord);
			break;
		case 'H':
			recordH.put(RecordID, teacherRecord);
			break;
		case 'I':
			recordI.put(RecordID, teacherRecord);
			break;
		case 'J':
			recordJ.put(RecordID, teacherRecord);
			break;
		case 'K':
			recordK.put(RecordID, teacherRecord);
			break;
		case 'L':
			recordL.put(RecordID, teacherRecord);
			break;
		case 'M':
			recordM.put(RecordID, teacherRecord);
			break;
		case 'N':
			recordN.put(RecordID, teacherRecord);
			break;
		case 'O':
			recordO.put(RecordID, teacherRecord);
			break;
		case 'P':
			recordP.put(RecordID, teacherRecord);
			break;
		case 'Q':
			recordQ.put(RecordID, teacherRecord);
			break;
		case 'R':
			recordR.put(RecordID, teacherRecord);
			break;
		case 'S':
			recordS.put(RecordID, teacherRecord);
			break;
		case 'T':
			recordT.put(RecordID, teacherRecord);
			break;
		case 'U':
			recordU.put(RecordID, teacherRecord);
			break;
		case 'V':
			recordV.put(RecordID, teacherRecord);
			break;
		case 'W':
			recordW.put(RecordID, teacherRecord);
			break;
		case 'X':
			recordX.put(RecordID, teacherRecord);
			break;
		case 'Y':
			recordY.put(RecordID, teacherRecord);
			break;
		case 'Z':
			recordZ.put(RecordID, teacherRecord);
			break;
		}
		
		increaseTeacherCount();

		Log.write(managerID + "\t\tCreate Teacher Record :   " + RecordID + "\n\r" + firstName 
				+ "   " + lastName + "   " + address + "   " + phone + "   " + specialization 
				+ "   " + location, serverFilePath);
		return true;
	}
	
	/**
	 * create student record in this server.
	 */
	@Override
	public synchronized boolean createSRecord(String managerID, String firstName, String lastName, String courseRegistered,
			String status, String statusDate) throws RemoteException {
		StudentRecord studentRecord = new StudentRecord(firstName, lastName, courseRegistered, status, statusDate);
		String RecordID = "SR" + String.valueOf(10001 + countOfStudent);
		
		switch(lastName.charAt(0)) {
		
		case 'A':
			recordA.put(RecordID, studentRecord);
			break;
		case 'B':
			recordB.put(RecordID, studentRecord);
			break;
		case 'C':
			recordC.put(RecordID, studentRecord);
			break;
		case 'D':
			recordD.put(RecordID, studentRecord);
			break;
		case 'E':
			recordE.put(RecordID, studentRecord);
			break;
		case 'F':
			recordF.put(RecordID, studentRecord);
			break;
		case 'G':
			recordG.put(RecordID, studentRecord);
			break;
		case 'H':
			recordH.put(RecordID, studentRecord);
			break;
		case 'I':
			recordI.put(RecordID, studentRecord);
			break;
		case 'J':
			recordJ.put(RecordID, studentRecord);
			break;
		case 'K':
			recordK.put(RecordID, studentRecord);
			break;
		case 'L':
			recordL.put(RecordID, studentRecord);
			break;
		case 'M':
			recordM.put(RecordID, studentRecord);
			break;
		case 'N':
			recordN.put(RecordID, studentRecord);
			break;
		case 'O':
			recordO.put(RecordID, studentRecord);
			break;
		case 'P':
			recordP.put(RecordID, studentRecord);
			break;
		case 'Q':
			recordQ.put(RecordID, studentRecord);
			break;
		case 'R':
			recordR.put(RecordID, studentRecord);
			break;
		case 'S':
			recordS.put(RecordID, studentRecord);
			break;
		case 'T':
			recordT.put(RecordID, studentRecord);
			break;
		case 'U':
			recordU.put(RecordID, studentRecord);
			break;
		case 'V':
			recordV.put(RecordID, studentRecord);
			break;
		case 'W':
			recordW.put(RecordID, studentRecord);
			break;
		case 'X':
			recordX.put(RecordID, studentRecord);
			break;
		case 'Y':
			recordY.put(RecordID, studentRecord);
			break;
		case 'Z':
			recordZ.put(RecordID, studentRecord);
			break;
		}
		
		increaseStudentCount();

		Log.write(managerID + "\t\tCreate Student Record :   " + RecordID + "\n\r" + firstName 
				+ "   " + lastName + "   " + courseRegistered + "   " + status + "   " 
				+ statusDate , serverFilePath);
		
		return true;
	}

	/**
	 * get manager's request and get the other server's count by UDP, then return to manager.
	 */
	@Override
	public synchronized String getRecordCounts() throws RemoteException {
		
			DatagramSocket mySocket = null;
			try{
				mySocket = new DatagramSocket();
				byte[] m = "request".getBytes();
				InetAddress host = InetAddress.getByName("localhost");
				int mtlPort = 4001;
				int lvlPort = 4002;
				int ddoPort = 4003;
				
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

				return result1.trim() + "\n" + result2.trim() + "\n" + result3.trim();
				
			} catch(Exception e) {
				
			} finally {
				if(mySocket != null){
					mySocket.close();
				}
			}	
		return null;
	}

	/**
	 * edit record via recordID
	 */
	@Override
	public synchronized boolean editRecord(String managerID, String recordID, String fieldName, 
			String newValue) throws RemoteException {

		for(char i = 'A'; i <= 'Z'; i++) {
			HashMap<String, Record> record = Records.get(i);
			
			if(record.get(recordID) != null) {
				
				if(recordID.substring(0, 2).equals("SR") ) {
					StudentRecord fix = (StudentRecord)record.get(recordID);
					if(fieldName.equals("courseRegistered"))
						fix.courseRegistered = newValue;
					else if(fieldName.equals("status"))
						fix.status = newValue;
					else if(fieldName.equals("statusDate"))
						fix.statusDate = newValue;
					else {
						Log.write(managerID + " fail to edit---FieldName cannot match", serverFilePath);
						return false;
					}
					
				} else {
					TeacherRecord fix = (TeacherRecord)record.get(recordID);
					if(fieldName.equals("address"))
						fix.address = newValue;
					else if(fieldName.equals("phone"))
						fix.phone = newValue;
					else if(fieldName.equals("location"))
						fix.location = newValue;
					else {
						Log.write(managerID + " fail to edit---FieldName cannot match", serverFilePath);
						return false;
					}	
					
				}
				
				break;
				
			} else {
				if(i < 'Z')
					continue;
				else {
					Log.write(managerID + " fail to edit---Invalid RecordID", serverFilePath);
					return false;
				}
			}	
		}
		
		
		Log.write(managerID + "---Record edit---" + recordID + "\n" + fieldName + 
				" : " + newValue , serverFilePath);

		Log.write(managerID + "---Record edit success", serverFilePath);
		return true;
	}
}


