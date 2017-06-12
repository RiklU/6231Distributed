package record;

import java.util.Date;
import java.io.FileWriter;
import java.text.SimpleDateFormat; 

public class Log {

	public static void write(String log, String file){
		
		try {
			FileWriter writer = new FileWriter(file, true);
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			String time = dateFormat.format(now);
			writer.append(time + " : " + log + "\r\n");
			writer.close();
		} catch(Exception e) {
			
		}
	}
}
