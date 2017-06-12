package drive;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import manager.CenterServer;
import manager.ManagerClient;
import record.Log;

public class DriveServer {
	public static void main(String[] args) {
try{
			
			CenterServer clientM = new CenterServer("MTL");
			CenterServer clientL = new CenterServer("LVL");
			CenterServer clientD = new CenterServer("DDO");

			Registry rM = LocateRegistry.createRegistry(5100);
			Registry rL = LocateRegistry.createRegistry(5101);
			Registry rD = LocateRegistry.createRegistry(5102);
			
			rM.rebind("test", clientM);
			rL.rebind("test", clientL);
			rD.rebind("test", clientD);
			
			Log.write("Server start", "MTLServer.txt");
			Log.write("Server start", "LVLServer.txt");
			Log.write("Server start", "DDOServer.txt");
			
			Thread t1 = new Thread(clientM);
			t1.start();
			Thread t2 = new Thread(clientL);
			t2.start();
			Thread t3 = new Thread(clientD);
			t3.start();
			
		} catch(Exception ex){
			ex.printStackTrace();
		}

	}



}
