package record;

import java.io.*;


public class StudentRecord extends Record implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String courseRegistered;
	public String status;
	public String statusDate;
	
	public StudentRecord(String firstName, String lastName, String courseRegistered, 
			String status, String statusDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseRegistered = courseRegistered;
		this.status = status;
		this.statusDate = statusDate;
	}
}
