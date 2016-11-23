/**
 * This class extends the jgrapht DefaultWeightedEdge class
 * and allows edges to contain, as well as edge weights, the 
 * following data:<br>
 * 
 * 1. Price <br>
 * 2. Flight Number <br>
 * 3. Departure Time <br>
 * 4. Arrival Time <br>
 * 5. Flight Duration 
 * 
 * <img src="/home/cs2/ns53/Desktop/santiago_small.jpg"/>
 * @author ns53
 *
 */

/* ******************************************************
* Part C: Additional Flight Information                           *
****************************************************** */
public class FlightData extends org.jgrapht.graph.DefaultWeightedEdge {
	
	
	private static final long serialVersionUID = 1L;
	
	private String Number, Depart, Arrive, time;
	private Integer Price;
	

	public FlightData (Integer Price, String Number, String Depart, String Arrive, String time){
		this.Price = Price;
		this.Number = Number;
		this.Depart = Depart;
		this.Arrive = Arrive;
		
		this.time = time;
		
	}
	
	public String getTime() {
		return time;
	}
	
	public Integer getPrice(){
		return Price;
	}
	
	
	
	public String getNumber(){
		return Number;
	}
	
	public String getDepart(){
		return Depart;
	}
	
	public String getArrive(){
		return Arrive;
	}
	
	
	
}
