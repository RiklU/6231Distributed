package record;

import java.io.*;


public class Record implements Serializable{
	
	public static int num = 0;
	public String firstName;
	public String lastName;
	public String recordID;
	public String type;
	
	
	public synchronized void numIncre(){
		num++;
	}
	
	public synchronized void numdecre(){
		num--;
	}

}
