import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.*;
import java.util.*;

public class PartC {

	public static void main(String[] args){
		  // create a graph based on URL objects
        WeightedMultigraph<String, DefaultWeightedEdge> hrefGraph = createhrefGraph();

        // note directed edges are printed as: (<v1>,<v2>)
        System.out.println(hrefGraph.toString());
	}
	
	public static WeightedMultigraph<String, DefaultWeightedEdge> createhrefGraph() {
		
		WeightedMultigraph<String, DefaultWeightedEdge> g = new WeightedMultigraph<>(DefaultWeightedEdge.class);
		
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
        DefaultWeightedEdge EHNUM = g.addEdge(Edinburgh, Heathrow);
        
        DefaultWeightedEdge HD = g.addEdge(Heathrow, Dubai);
        DefaultWeightedEdge HDNUM = g.addEdge(Heathrow, Dubai);
        
        
       
        
        DefaultWeightedEdge HS = g.addEdge(Heathrow, Sydney);
        DefaultWeightedEdge HSNUM = g.addEdge(Heathrow, Sydney);
     
        
        DefaultWeightedEdge DKL = g.addEdge(Dubai, KualaLumpur);
        DefaultWeightedEdge DKLNUM = g.addEdge(Dubai, KualaLumpur);
        
        
        DefaultWeightedEdge DE = g.addEdge(Dubai, Edinburgh);
        DefaultWeightedEdge DENUM = g.addEdge(Dubai, Edinburgh);
        
        
        DefaultWeightedEdge KLS = g.addEdge(KualaLumpur, Sydney);
        DefaultWeightedEdge KLSNUM = g.addEdge(KualaLumpur, Sydney);
        
        
        DefaultWeightedEdge EF = g.addEdge(Edinburgh, Frankfurt);
        DefaultWeightedEdge EFNUM = g.addEdge(Edinburgh, Frankfurt);
        
        
        DefaultWeightedEdge SA = g.addEdge(Sydney, Auckland);
        DefaultWeightedEdge SANUM = g.addEdge(Sydney, Auckland);
        
        
        DefaultWeightedEdge RNY = g.addEdge(Rio, NY);
        DefaultWeightedEdge RNYNUM = g.addEdge(Rio, NY);
        
        
        DefaultWeightedEdge NYS = g.addEdge(NY, Santiago);
        DefaultWeightedEdge NYSNUM = g.addEdge(NY, Santiago);
        
        
        g.setEdgeWeight(EH, 80);
        
        
        
        g.setEdgeWeight(HD, 130);
        
        
        g.setEdgeWeight(HS, 570);
      
        
        g.setEdgeWeight(DKL, 170);
       
        
        
        g.setEdgeWeight(DE, 190);
        
        
        g.setEdgeWeight(KLS, 150);
        
        
        g.setEdgeWeight(EF, 90);
       
        
        g.setEdgeWeight(SA, 120);
       
        
        g.setEdgeWeight(RNY, 430);
       
        
        g.setEdgeWeight(NYS, 320);
        
		
		return g;
		
		
	}
}
