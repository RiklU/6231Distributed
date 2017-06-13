package record;

import java.io.*;

public class DoctorRecord extends Record implements Serializable{
	
	public String address;
	public String phone;
	public String specialization;
	public String location;
	
	public DoctorRecord(String firstName,String lastName,String address,String phone,String specialization,String location){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.specialization = specialization;
		this.location = location;
		int id = num+10000;
		recordID = "DR"+id;
		numIncre();
		type = "DR";
		
	}

}
