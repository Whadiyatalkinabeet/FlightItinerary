
public class FlightData extends org.jgrapht.graph.DefaultWeightedEdge {
	
	
	private static final long serialVersionUID = 1L;
	
	private String Number, Depart, Arrive;
	private Integer Price, Length;
	

	public FlightData (Integer Price, String Number, String Depart, String Arrive, Integer Length){
		this.Price = Price;
		this.Number = Number;
		this.Depart = Depart;
		this.Arrive = Arrive;
		this.Length = Length;
		
		
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
	
	public Integer getLength(){
		return Length;
	}
	
}
