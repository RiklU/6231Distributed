package drive;

import java.rmi.RemoteException;
import java.util.Scanner;
import manager.ManagerClient;

public class DriveManager {
	public static void main(String[] args) {
		System.out.println("Please enter managerID : ");
		Scanner in3 = new Scanner(System.in);
		try {
			new ManagerClient(in3.nextLine()) ;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//in3.close();
		
		///yhis sis a test
	}       

}
