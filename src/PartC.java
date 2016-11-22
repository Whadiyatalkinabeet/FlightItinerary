
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.*;

import java.text.ParseException;
import java.util.*;

public class PartC {

	public static void main(String[] args) throws ParseException{
		  // create a graph based on URL objects
		SimpleDirectedWeightedGraph<String, FlightData> Graph = FlightPaths();
		TimeBuilder time = new TimeBuilder();
        // note directed edges are printed as: (<v1>,<v2>)
        System.out.println(Graph.toString());
        
        Scanner in = new Scanner(System.in);
        String startVertex, endVertex;
        
        System.out.println("Please enter the start airport:");
        startVertex = in.nextLine();
        
        System.out.println("Please enter the end airport");
        endVertex = in.nextLine();
        
        DijkstraShortestPath<String, FlightData> shortestPath = new DijkstraShortestPath<String, FlightData>
        (Graph, startVertex, endVertex);
        
        
        
        Iterator<FlightData> iterator = shortestPath.getPathEdgeList().iterator();
        
        
        
        FlightData r;
        int i = 0;
        int totalPrice = 0;
        int totalTime = 0;
        String ttest = "00:00";
        
        System.out.println("Leg\t" + "From\t" + "To\t\t" +  "Departs\t" +  "Arrives\t" +  "On");
        
        while (iterator.hasNext()){
        	r = iterator.next();
        	i += 1;
        	totalPrice += r.getPrice();
        	totalTime += r.getLength();
        	ttest = time.Add(ttest, r.getTime());
        	System.out.println(i + ".\t" + r + "\t" + r.getDepart() + "\t" + r.getArrive() + "\t" + r.getNumber());
        	
        }
        System.out.println("Total Journey Cost = £" + totalPrice + ".");
        ArrayList<String> split = time.getData(ttest);
        System.out.println("Total Time in the Air = " + split.get(0) + "h " + split.get(1) + "m.");
       
        
       
       
        
        
        
	}
	
	public static SimpleDirectedWeightedGraph<String, FlightData> FlightPaths() {
		
		SimpleDirectedWeightedGraph<String, FlightData> g = new SimpleDirectedWeightedGraph<>(FlightData.class);
		
	    String Edinburgh = "Edinburgh";
        String Heathrow = "Heathrow";
        String Dubai = "Dubai";
        String KualaLumpur = "Kuala Lumpur";
        String Sydney = "Sydney";
        String Rio = "Rio de Janeiro";
        String NY = "NewYork";
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
        
        
        FlightData EH = new FlightData(80, "BA354", "1830", "0127", 1, "01:27");
        g.addEdge(Edinburgh, Heathrow, EH);
        g.setEdgeWeight(EH, EH.getPrice());
        
     
        FlightData HE = new FlightData(80, "BA354", "1830", "0127", 1, "01:27");
        g.addEdge(Heathrow, Edinburgh, HE);
        g.setEdgeWeight(HE, HE.getPrice());
        
        
        FlightData HD = new FlightData(130, "BA353", "0200", "1010", 8, "08:10");
        g.addEdge(Heathrow, Dubai, HD);
        g.setEdgeWeight(HD, HD.getPrice());
        
        
        FlightData DH = new FlightData(130, "BA353", "0200", "1010", 8, "08:10");
        g.addEdge(Dubai, Heathrow, DH);
        g.setEdgeWeight(DH, DH.getPrice());
        
        
        FlightData HS = new FlightData(570, "BA352", "0100", "1205", 11, "11:05");
        g.addEdge(Heathrow, Sydney, HS);
        g.setEdgeWeight(HS, HS.getPrice());
        
       
        FlightData SH = new FlightData(570, "BA352", "0100", "1205", 11, "11:05");
        g.addEdge(Sydney, Heathrow, SH);
        g.setEdgeWeight(SH, SH.getPrice());
        
     
        
        FlightData DKL = new FlightData(170, "BA351", "1300", "1800", 5, "05:00");
        g.addEdge(Dubai, KualaLumpur, DKL);
        g.setEdgeWeight(DKL, DKL.getPrice());
        
        
        FlightData KLD = new FlightData(170, "BA351", "1300", "1800", 5, "05:00");
        g.addEdge(KualaLumpur, Dubai, KLD);
        g.setEdgeWeight(KLD, KLD.getPrice());
        
       
        
        
        FlightData DE = new FlightData(190, "BA350", "1400", "2330", 9, "09:30");
        g.addEdge(Dubai, Edinburgh, DE);
        g.setEdgeWeight(DE, DE.getPrice());
       
        
        FlightData ED = new FlightData(190, "BA350", "1400", "2330", 9, "09:30");
        g.addEdge(Edinburgh, Dubai, ED);
        g.setEdgeWeight(ED, ED.getPrice());
        
       
        
        
        FlightData KLS = new FlightData(150, "BA349", "1900", "0015", 5, "05:15");
        g.addEdge(KualaLumpur, Sydney, KLS);
        g.setEdgeWeight(KLS, KLS.getPrice());
        
        
        FlightData SKL = new FlightData(150, "BA349", "1900", "0015", 5, "05:15");
        g.addEdge(Sydney, KualaLumpur, SKL);
        g.setEdgeWeight(SKL, SKL.getPrice());
       
        
        
        
        FlightData EF = new FlightData(90, "BA348", "0700", "1045", 3, "03:45");
        g.addEdge(Edinburgh, Frankfurt, EF);
        g.setEdgeWeight(EF, EF.getPrice());
        
       
        FlightData FE = new FlightData(90, "BA348", "0700", "1045", 3, "03:45");
        g.addEdge(Frankfurt, Edinburgh, FE);
        g.setEdgeWeight(FE, FE.getPrice());
        
        
        
        FlightData SA = new FlightData(120, "BA347", "1600", "2000", 4, "04:00");
        g.addEdge(Sydney, Auckland, SA);
        g.setEdgeWeight(SA, SA.getPrice());
        
        
        FlightData AS = new FlightData(120, "BA347", "1600", "2000", 4, "04:00");
        g.addEdge(Auckland, Sydney, AS);
        g.setEdgeWeight(AS, AS.getPrice());
        
  
        
        
        FlightData RNY = new FlightData(430, "BA346", "0200", "1024", 8, "08:24");
        g.addEdge(Rio, NY, RNY);
        g.setEdgeWeight(RNY, RNY.getPrice());
        
        
        FlightData NYR = new FlightData(430, "BA346", "0200", "1024", 8, "08:24");
        g.addEdge(NY, Rio, NYR);
        g.setEdgeWeight(NYR, NYR.getPrice());
        
       
        
        
        FlightData NYS = new FlightData(320, "BA345", "1200", "2005", 8, "08:05");
        g.addEdge(NY, Santiago, NYS);
        g.setEdgeWeight(NYS, NYS.getPrice());
        
        
        FlightData SNY = new FlightData(320, "BA345", "1200", "2005", 8, "08:05");
        g.addEdge(Santiago, NY, SNY);
        g.setEdgeWeight(SNY, SNY.getPrice());
        
       
        
        
        
        return g;
		
		
	}
	
	
}
