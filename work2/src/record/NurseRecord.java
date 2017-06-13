package record;

import java.io.*;


public class NurseRecord extends Record implements Serializable{
	
	public String designation;
	public String status;
	public String statusDate;
	
	public NurseRecord(String firstName,String lastName,String designation,String status,String statusDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.status = status;
		this.statusDate = statusDate;
		int id = num+10000;
		recordID = "NR"+id;
		numIncre();
		type = "NR";
		
	}

}
