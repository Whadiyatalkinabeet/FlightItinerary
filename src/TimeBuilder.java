
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeBuilder {
	
	
	
	public String getDuration (String time1, String time2) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		
		Date date1 = format.parse(time1); 
		Date date2 = format.parse(time2);
		
	
		long difference = Math.abs(date2.getTime() - date1.getTime());
		
		
		Long diffhours = difference / (60 * 60 * 1000) % 24;
		Long diffminutes = difference / (60 * 1000) % 60;
		
		
		
		String duration = "";
		
		String check1 = diffhours.toString();
		String check2 = diffminutes.toString();
		
		
		
		
		if (check1.length() != 2) {
			check1 = "0" + check1;
		}
		
		if (check2.length() != 2) {
			check2 = check2 + 0;
		}	
		
		
	
		duration = check1 + ":" + check2;
		
		return duration ;
	}
	
	public String Add (String time1, String time2) throws ParseException{

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		
		Date date1 = format.parse(time1); 
		Date date2 = format.parse(time2);
		
	
		long difference = Math.abs(date2.getTime() + date1.getTime());
		
		
		Long diffhours = difference / (60 * 60 * 1000) % 24;
		Long diffminutes = difference / (60 * 1000) % 60;
		
		
		
		String duration = "";
		
		String check1 = diffhours.toString();
		String check2 = diffminutes.toString();
		
		
		
		
		if (check1.length() != 2) {
			check1 = "0" + check1;
		}
		
		if (check2.length() != 2) {
			check2 = check2 + 0;
		}	
		
		
	
		duration = check1 + ":" + check2;
		
		return duration ;
		
	}
}
