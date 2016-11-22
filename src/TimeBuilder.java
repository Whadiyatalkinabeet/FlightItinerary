
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class TimeBuilder {
	
	
	
	public String getDuration (String time1, String time2) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date date1 = format.parse(time1); 
		Date date2 = format.parse(time2);
		
		
		
		Long difference = Math.abs((date2.getTime() - date1.getTime()));
		
		
		
		Long diffhours = difference / (60 * 60 * 1000) % 24;
		Long diffminutes = difference / (60 * 1000) % 60;
		
		
		
		String duration = "";
		
		String check1 = diffhours.toString();
		String check2 = diffminutes.toString();
		
		
		
		
		if (check1.length() != 2) {
			check1 = "0" + check1;
		}
		
		if (check2.length() != 2) {
			check2 = "0" + check2;
		}	
		
		
	
		duration = check1 + ":" + check2;
		
		if (date2.compareTo(date1) > 0) {
			return duration;
			
		} 
		
		
			String duration2 = (Add2(duration, "24:00"));
		
			return duration2 ;
		}
		
		
	
	
	
	
	public String Add (String time1, String time2) throws ParseException{

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date date1 = format.parse(time1); 
		Date date2 = format.parse(time2);
		
	
		Long duration = Math.abs(date2.getTime() + date1.getTime());
		
		Long diffhours = duration / (60 * 60 * 1000);
		Long diffminutes = duration / (60 * 1000) % 60;
		
		
		
		String add = "";
		
		String check1 = diffhours.toString();
		String check2 = diffminutes.toString();
		
		
		
		
		if (check1.length() != 2) {
			check1 = "0" + check1;
		}
		
		if (check2.length() != 2) {
			check2 = "0" + check2;
		}	
		
		
		
		add = check1 + ":" + check2;
		
		return add ;
		
	}
	
	public String Add2 (String time1, String time2) throws ParseException{

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		Date date1 = format.parse(time1); 
		Date date2 = format.parse(time2);
		
	
		Long duration = Math.abs(date2.getTime() - date1.getTime());
		
		Long diffhours = duration / (60 * 60 * 1000) % 24;
		Long diffminutes = duration / (60 * 1000) % 60;
		
		
		
		String add = "";
		
		String check1 = diffhours.toString();
		String check2 = diffminutes.toString();
		
		
		
		
		if (check1.length() != 2) {
			check1 = "0" + check1;
		}
		
		if (check2.length() != 2) {
			check2 = "0" + check2;
		}	
		
		
		
		add = check1 + ":" + check2;
		
		return add ;
		
	}
	
	public ArrayList<String> getData(String time) {
		
		StringBuilder sb = new StringBuilder(time);
		ArrayList<String> splitter = new ArrayList<>();
		
		for (String splitTime : time.split(":")){
			splitter.add(splitTime);
		}
		
		return splitter;
		
		
	}
	
	
}
