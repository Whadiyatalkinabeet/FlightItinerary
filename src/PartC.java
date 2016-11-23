/**		Nyal Sadiq ns53@hw.ac.uk
 * 	
 * 			Data Structures and Algorithms Coursework 2
 * 		
 * 				Part A-E
 * 			
 * 					Part F - 1. 2. 4.
 */
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.*;

import java.text.ParseException;
import java.util.*;
/**
 * This Class Implements <strong>Parts A-E</strong>
 *This Class Implements the following parts of <strong>Part F:</strong><br>
 *
 *<strong>
 *1.<br>
 *2.<br>
 *4.<br>
 *</strong>
 *
 * @author ns53
 *
 */
public class PartC {
	
	/**
	 * This method will set all of the edge weights of a given graph to zero.
	 * @param graph
	 */
	public static void RemoveEdgeWeights(SimpleDirectedWeightedGraph<String, FlightData> graph) {
		
		Iterator<FlightData> iterator = graph.edgeSet().iterator();
		
		while (iterator.hasNext()){
			FlightData edge = iterator.next();
			graph.setEdgeWeight(edge, 0);
		}
		
		
	}
	/**
	 * The main class will call the FlightPaths() method to generate a graph.<br>
	 * The user will be asked for input here and two itineraries will be generated.<br>
	 * 
	 * The itineraries will contain:<br>
	 * <strong>
	 * 1. The Cheapest Journey<br>
	 * 2. The Shortest Journey
	 * </strong>
	 * 
	 * 
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws NoPathException, ParseException{
		  
		SimpleDirectedWeightedGraph<String, FlightData> Graph = FlightPaths();
		
		TimeBuilder time = new TimeBuilder();
		
		Scanner in = new Scanner(System.in);
		 
		String startVertex, endVertex;
        
		Iterator<String> airports = Graph.vertexSet().iterator();
	        
		while (airports.hasNext()){
			System.out.println(airports.next());
		}
        
		
        Boolean flag = false;
        while (flag == false){
        	
        	System.out.println("Please enter the start airport:");
        	startVertex = in.nextLine();
        
        	System.out.println("Please enter the end airport");
        	endVertex = in.nextLine();
        
        	System.out.println("_____________________________________________");
        	System.out.println("______________CHEAPEST JOURNEY_______________");
        
        	try {
        		DijkstraShortestPath<String, FlightData> cheapestPath = new DijkstraShortestPath<String, FlightData>
        		(Graph, startVertex, endVertex);
        		GenerateItinerary(cheapestPath, time);
        		flag = true;
        	} catch (IllegalArgumentException e) {
        		System.out.println("No path between " + startVertex + " and " + endVertex + ", yet.");
        	}
        
        
        	System.out.println("_____________________________________________");
        
        
        
        
        	if (flag == true){
			RemoveEdgeWeights(Graph);	
		}
        
        	System.out.println("_____________________________________________");
        	System.out.println("______________SHORTEST JOURNEY_______________");
        
        	try {
        		DijkstraShortestPath<String, FlightData> shortestPath = new DijkstraShortestPath<String, FlightData>
        		(Graph, startVertex, endVertex);
        		GenerateItinerary(shortestPath, time);
        		flag = true;
        	} catch (IllegalArgumentException e){
        		System.out.println("No path between " + startVertex + " and " + endVertex + ", yet.");
        	}
       
        	System.out.println("_____________________________________________");
        
        }
    
        
	}
        
    public static void GenerateItinerary (DijkstraShortestPath<String, FlightData> shortestPath, TimeBuilder time) throws ParseException {
        
        Iterator<FlightData> iterator = shortestPath.getPathEdgeList().iterator();
        Iterator<FlightData> Arrivals = shortestPath.getPathEdgeList().iterator();
        Iterator<FlightData> Departures = shortestPath.getPathEdgeList().iterator();
        
        
        
        FlightData r;
        int i = 0;
        int totalPrice = 0;
        
        String ttest = "00:00";
        
        
        
        System.out.println("Leg\t" + "From\t" + "To\t\t" +  "Departs\t" +  "Arrives\t" +  "On");
        
        while (iterator.hasNext()){
        	r = iterator.next();
        	i += 1;
        	totalPrice += r.getPrice();
      
        	ttest = time.Add(ttest, r.getTime());
        	System.out.println(i + ".\t" + r + "\t" + r.getDepart() + "\t" + r.getArrive() + "\t" + r.getNumber());
        	
        }
        
        FlightData Arrive, Depart;
        String changeover = "00:00";
        
       
       Depart = Departures.next();
        
        while(Departures.hasNext()){
        	Arrive = Arrivals.next();
        	
        	changeover = time.Add(changeover, time.getDuration(Arrive.getArrive(), Departures.next().getDepart()));
        	
        }
        
        
        System.out.println("Total Journey Cost = £" + totalPrice + ".");
        ArrayList<String> splitTime = time.getData(ttest);
        ArrayList<String> splitChangeOver = time.getData(changeover);
        
    
        System.out.println("Total Time in the Air = " + splitTime.get(0) + "h " + splitTime.get(1) + "m.");
        System.out.println("Changeover time = " + splitChangeOver.get(0) + "h " + splitChangeOver.get(1) + "m.");
        String TotalTime = time.Add(ttest, changeover);
        
        ArrayList<String> splitTotalTime = time.getData(TotalTime);
        System.out.println("Total Journey Time = " + splitTotalTime.get(0) + "h " + splitTotalTime.get(1) + "m. ");
        
       
        
        
        //----------------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------------------------------------------------
        
     
    }
        
        
	
	/**
	 * This method will generate a SimpleDirectedWeightedGraph.<br>
	 * The graph's edges will be defined by the <strong>FlightData edge</strong> class.
	 * 
	 * 
	 * @return
	 * SimpleDirectedWeightedGraph<String, FlightData>
	 */
	public static SimpleDirectedWeightedGraph<String, FlightData> FlightPaths() {
		
		SimpleDirectedWeightedGraph<String, FlightData> g = new SimpleDirectedWeightedGraph<>(FlightData.class);
		
	    String Edinburgh = "Edinburgh";
        String Heathrow = "Heathrow";
        String Dubai = "Dubai";
        String KualaLumpur = "Kuala Lumpur";
        String Sydney = "Sydney";
        String Rio = "Rio de Janeiro";
        String NY = "New York";
        String Frankfurt = "Frankfurt";
        String Auckland = "Auckland";
        String Santiago = "Santiago";
        
        
        
        // add the vertices
        g.addVertex(Edinburgh);
        g.addVertex(Heathrow);
        g.addVertex(Dubai);
        g.addVertex(KualaLumpur);
        g.addVertex(Sydney);
        g.addVertex(Rio);
        g.addVertex(NY);
        g.addVertex(Frankfurt);
        g.addVertex(Auckland);
        g.addVertex(Santiago);
        
      
        

        // add edges to create linking structure
        
        
        FlightData EH = new FlightData(80, "BA354", "21:30", "04:00","06:30");
        g.addEdge(Edinburgh, Heathrow, EH);
        g.setEdgeWeight(EH, EH.getPrice());
        
     
        FlightData HE = new FlightData(80, "BA354", "21:30", "04:00", "06:30");
        g.addEdge(Heathrow, Edinburgh, HE);
        g.setEdgeWeight(HE, HE.getPrice());
        
        
        FlightData HD = new FlightData(130, "BA353", "02:00", "10:10", "08:10");
        g.addEdge(Heathrow, Dubai, HD);
        g.setEdgeWeight(HD, HD.getPrice());
        
        
        FlightData DH = new FlightData(130, "BA353", "02:00", "10:10", "08:10");
        g.addEdge(Dubai, Heathrow, DH);
        g.setEdgeWeight(DH, DH.getPrice());
        
        
        FlightData HS = new FlightData(570, "BA352", "01:00", "12:05", "11:05");
        g.addEdge(Heathrow, Sydney, HS);
        g.setEdgeWeight(HS, HS.getPrice());
        
       
        FlightData SH = new FlightData(570, "BA352", "01:00", "12:05", "11:05");
        g.addEdge(Sydney, Heathrow, SH);
        g.setEdgeWeight(SH, SH.getPrice());
        
     
        
        FlightData DKL = new FlightData(170, "BA351", "13:00", "18:00", "05:00");
        g.addEdge(Dubai, KualaLumpur, DKL);
        g.setEdgeWeight(DKL, DKL.getPrice());
        
        
        FlightData KLD = new FlightData(170, "BA351", "13:00", "18:00", "05:00");
        g.addEdge(KualaLumpur, Dubai, KLD);
        g.setEdgeWeight(KLD, KLD.getPrice());
        
       
        
        
        FlightData DE = new FlightData(190, "BA350", "14:00", "23:30", "09:30");
        g.addEdge(Dubai, Edinburgh, DE);
        g.setEdgeWeight(DE, DE.getPrice());
       
        
        FlightData ED = new FlightData(190, "BA350", "14:00", "23:30", "09:30");
        g.addEdge(Edinburgh, Dubai, ED);
        g.setEdgeWeight(ED, ED.getPrice());
        
       
        
        
        FlightData KLS = new FlightData(150, "BA349", "19:00", "00:15", "05:15");
        g.addEdge(KualaLumpur, Sydney, KLS);
        g.setEdgeWeight(KLS, KLS.getPrice());
        
        
        FlightData SKL = new FlightData(150, "BA349", "19:00", "00:15", "05:15");
        g.addEdge(Sydney, KualaLumpur, SKL);
        g.setEdgeWeight(SKL, SKL.getPrice());
       
        
        
        
        FlightData EF = new FlightData(90, "BA348", "07:00", "10:45", "03:45");
        g.addEdge(Edinburgh, Frankfurt, EF);
        g.setEdgeWeight(EF, EF.getPrice());
        
       
        FlightData FE = new FlightData(90, "BA348", "07:00", "10:45", "03:45");
        g.addEdge(Frankfurt, Edinburgh, FE);
        g.setEdgeWeight(FE, FE.getPrice());
        
        
        
        FlightData SA = new FlightData(120, "BA347", "16:00", "20:00", "04:00");
        g.addEdge(Sydney, Auckland, SA);
        g.setEdgeWeight(SA, SA.getPrice());
        
        
        FlightData AS = new FlightData(120, "BA347", "16:00", "20:00", "04:00");
        g.addEdge(Auckland, Sydney, AS);
        g.setEdgeWeight(AS, AS.getPrice());
        
  
        
        
        FlightData RNY = new FlightData(430, "BA346", "02:00", "10:24", "08:24");
        g.addEdge(Rio, NY, RNY);
        g.setEdgeWeight(RNY, RNY.getPrice());
        
        
        FlightData NYR = new FlightData(430, "BA346", "02:00", "10:24", "08:24");
        g.addEdge(NY, Rio, NYR);
        g.setEdgeWeight(NYR, NYR.getPrice());
        
       
        
        
        FlightData NYS = new FlightData(320, "BA345", "12:00", "20:05", "08:05");
        g.addEdge(NY, Santiago, NYS);
        g.setEdgeWeight(NYS, NYS.getPrice());
        
        
        FlightData SNY = new FlightData(320, "BA345", "12:00", "20:05", "08:05");
        g.addEdge(Santiago, NY, SNY);
        g.setEdgeWeight(SNY, SNY.getPrice());
        
       
        
        
        
        return g;
		
		
	}
	
	
	
	
}
