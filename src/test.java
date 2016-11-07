
import java.net.*;
import java.util.*;
import org.jgrapht.*;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.generate.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;


public class test {
	
	

	public static void main(String[] args){
		  // create a graph based on URL objects
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> hrefGraph = createHrefGraph();

        // note directed edges are printed as: (<v1>,<v2>)
        System.out.println(hrefGraph.toString());
		
        Scanner in = new Scanner(System.in);
        String startVertex, endVertex;
        
        System.out.println("Please enter the start airport:");
        startVertex = in.nextLine();
        
        System.out.println("Please enter the end airport");
        endVertex = in.nextLine();
        
        DijkstraShortestPath<String, DefaultWeightedEdge> shortestPath = new DijkstraShortestPath<String, DefaultWeightedEdge>
        (hrefGraph, startVertex, endVertex);
        
        
        System.out.println("Shortest (i.e cheapest) path:");
       
        System.out.println(shortestPath.getPathEdgeList());
        
        String output = shortestPath.getPathEdgeList().toString();
        
        System.out.println(output);
        
        System.out.print("Cost of shortest (i.e cheapest) path = £");
        System.out.print(shortestPath.getPathLength());
		
	}
	
	 private static SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> createHrefGraph()
	    {
	        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> g = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

	        
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
	            
	            
	            DefaultWeightedEdge EH = g.addEdge(Edinburgh, Heathrow);
	            DefaultWeightedEdge HE = g.addEdge(Heathrow, Edinburgh);
	            
	            DefaultWeightedEdge HD = g.addEdge(Heathrow, Dubai);
	            DefaultWeightedEdge DH = g.addEdge(Dubai, Heathrow);
	            
	            DefaultWeightedEdge Leave = g.addEdge(Heathrow, Dubai);
	            DefaultWeightedEdge Arrive = g.addEdge(Heathrow, Dubai);
	            
	            DefaultWeightedEdge HS = g.addEdge(Heathrow, Sydney);
	            DefaultWeightedEdge SH = g.addEdge(Sydney, Heathrow);
	            
	            DefaultWeightedEdge DKL = g.addEdge(Dubai, KualaLumpur);
	            DefaultWeightedEdge KLD = g.addEdge(KualaLumpur, Dubai);
	            
	            DefaultWeightedEdge DE = g.addEdge(Dubai, Edinburgh);
	            DefaultWeightedEdge ED = g.addEdge(Edinburgh, Dubai);
	            
	            DefaultWeightedEdge KLS = g.addEdge(KualaLumpur, Sydney);
	            DefaultWeightedEdge SKL = g.addEdge(Sydney, KualaLumpur);
	            
	            DefaultWeightedEdge EF = g.addEdge(Edinburgh, Frankfurt);
	            DefaultWeightedEdge FE = g.addEdge(Frankfurt, Edinburgh);
	            
	            DefaultWeightedEdge SA = g.addEdge(Sydney, Auckland);
	            DefaultWeightedEdge AS = g.addEdge(Auckland, Sydney);
	            
	            DefaultWeightedEdge RNY = g.addEdge(Rio, NY);
	            DefaultWeightedEdge NYR = g.addEdge(NY, Rio);
	            
	            DefaultWeightedEdge NYS = g.addEdge(NY, Santiago);
	            DefaultWeightedEdge SNY = g.addEdge(Santiago, NY);
	            
	            g.setEdgeWeight(EH, 80);
	            g.setEdgeWeight(HE, 80);
	            
	            g.setEdgeWeight(HD, 130);
	            g.setEdgeWeight(DH, 130);
	            
	            g.setEdgeWeight(HS, 570);
	            g.setEdgeWeight(SH, 570);
	            
	            g.setEdgeWeight(DKL, 170);
	            g.setEdgeWeight(KLD, 170);
	            
	            
	            g.setEdgeWeight(DE, 190);
	            g.setEdgeWeight(ED, 190);
	            
	            g.setEdgeWeight(KLS, 150);
	            g.setEdgeWeight(SKL, 150);
	            
	            g.setEdgeWeight(EF, 90);
	            g.setEdgeWeight(FE, 90);
	            
	            g.setEdgeWeight(SA, 120);
	            g.setEdgeWeight(AS, 120);
	            
	            g.setEdgeWeight(RNY, 430);
	            g.setEdgeWeight(NYR, 430);
	            
	            g.setEdgeWeight(NYS, 320);
	            g.setEdgeWeight(SNY, 320);
	           
	           
	            
	          return g;
	    }
	
	
}
