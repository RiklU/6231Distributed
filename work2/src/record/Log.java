package record;

import java.io.*;
import java.util.Set;
import java.util.Date;
import java.util.HashMap;
import java.util.Calendar; 
import java.text.SimpleDateFormat; 

public class Log {

	public static void write(String log, String file){
		try{
			FileWriter writer = new FileWriter(file,true);
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			String time = dateFormat.format( now );
			writer.append(time+" : "+log+"\r\n");
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void writeRecord(HashMap <String,Record> hashmap, String file){
		try{
			FileWriter writer = new FileWriter(file,false);
			Set<String> keys = hashmap.keySet();
		    for(String key: keys) {
		    	if(hashmap.get(key).type.equals("DR")){
		    		DoctorRecord r = (DoctorRecord)hashmap.get(key);
		    		writer.append(key+" -- "+ r.firstName + " " + r.lastName  + " " + r.address 
		   				 + " " + r.phone + " " + r.specialization + " " + r.location + "\r\n");
		    	}else{
		    		NurseRecord r = (NurseRecord)hashmap.get(key);
		    		writer.append(key+" -- "+ r.firstName + " " + r.lastName  + " " +r.designation 
		   				 + " " + r.status + " " + r.statusDate + "\r\n");
		    	}
		    	
		    }
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
