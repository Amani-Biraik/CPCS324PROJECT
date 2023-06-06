package GraphFrameWork;

import AirFreightApp.Route;
import java.util.ArrayList;
import GraphFrameWork.Edge;
import AirFreightApp.Location;
import AirFreightApp.Route;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
    private Graph graph;
    private Vertex [] vertices;
    String startingPoint;
    SingleSourceSPAlg obj = new SingleSourceSPAlg(graph);
    public ArrayList<Edge> edges = new ArrayList<>();
    
    
    
    public DBAllSourceSPAlg(Graph graph){
        super(graph);
    }
    
    
    public void computeDijkstraBasedSPAlg(int vertNo, Vertex [] verticesArr, ArrayList<Edge> e) {
        this.graph = graph;
        this.vertices = verticesArr;
        
        
        
        
        //form single to rest of vertices
        int verticesNo = vertNo;
        
        
        
        for (int sourceVertex = 0; sourceVertex < verticesNo; sourceVertex++) {
            
            SingleSourceSPAlg single = new SingleSourceSPAlg(graph);
            
            single.computeDijkstraAlg(verticesArr[sourceVertex].getLabel(), vertNo, verticesArr, e);
            
            
        }
    }

    @Override
    public void displayShortestPath() {

        System.out.println("db");

            System.out.println("The Starting point location is:");

            // Initialize a list to store the routes
            ArrayList<Route> routes = new ArrayList<>();
            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i) instanceof Route) {
                    routes.add((Route) edges.get(i));
                }
            }
            // Sort the routes based on weights
            //Collections.sort(routes, Comparator.comparingInt(r -> r.getWeight()));

            Location location = new Location("A", "City");

            for (Route route : routes) {
                System.out.print("loc. " + route.getSource().getLabel() + ": " + location.getCity());
                System.out.print(" - loc. " + route.getTarget().getLabel() + ": " + location.getCity());
                System.out.println(" --- route length " + route.getWeight());
            }
         
    }
}
