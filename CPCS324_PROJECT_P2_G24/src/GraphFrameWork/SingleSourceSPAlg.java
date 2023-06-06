
package GraphFrameWork;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import GraphFrameWork.Edge;
import AirFreightApp.*;

import java.util.ArrayList;

public class SingleSourceSPAlg extends ShortestPathAlgorithm{
    private Graph graph;
    private Vertex [] vertices;
    public ArrayList<Edge> edges = new ArrayList<>();
    public ArrayList<Location> locations = new ArrayList();
    public int totalCost = 0;
    int [] smallestDistance; // save the smallest smallestDistance from source to the vertex
    String [] path;
    Vertex forCopy1 = new Vertex();
    Vertex forCopy2 = new Vertex();
    public static ArrayList<Edge> result = new ArrayList();
    public ArrayList<String> res = new ArrayList();
    public static Vertex[] verArray;
    public static int srcc;
    
    

    // Constructor
    public SingleSourceSPAlg(Graph graph) {
        super(graph);
        
    }
   
    
    
    

    // Getter
    public int getTotalCost() {
        return totalCost;
    }
    
    
    public void computeDijkstraAlg(String sourceStr, int vertNo, Vertex[] verticesArr, ArrayList<Edge> e){
        
       int infinity = Integer.MAX_VALUE;
       int numVertices = vertNo;
        
       int source = 0;
       verArray = verticesArr;
       
       System.out.print("The Starting point location is: ");
       System.out.println(sourceStr);
       
       
       
        // 
        for (int i=0; i<numVertices; i++){
            if (i >= source){
                if (verticesArr[i].getLabel().equals(sourceStr)){
                   source = i; 
                }
            }
        }
        
        
        String sourceLabel = verticesArr[source].getLabel();
        //int sourceLabelInt = Integer.parseInt(sourceLabel);


        smallestDistance = new int[numVertices];
        path = new String[numVertices];
        
        
        
        //update all the vertices smallestDistance as infinity except the src is 0
        for (int i = 0; i < numVertices; i++) {
            if (i >= source){
            for (int j = 0; j < numVertices; j++)
                smallestDistance[i] = infinity;
            }
        }
        smallestDistance[source] = 0;
        
        
        
        path[source] = verticesArr[source].getLabel();
        
        for (int i = 0; i < numVertices; i++) {
            if (i >= source) { 
            
                
                int u = 0;
                int minDistance = infinity;

                for (int j = 0; j < numVertices; j++) {
                    if (i >= source){
                        if (verticesArr[j].isIsVisited() == false && smallestDistance[j] < minDistance) {
                            minDistance = smallestDistance[j];
                            u = j;
                            forCopy1 = verticesArr[j];
                        }
                    }
                }


                //Once the smallest is found
                verticesArr[u].setIsVisited(true);

                
                //Update the adjacent distances  
                for (int v = 0; v < numVertices; v++) {
                    if (i >= source){
                        srcc = source;

                        if ( !verticesArr[v].isIsVisited() && weight(forCopy1,verticesArr[v] , e) != infinity && weight(forCopy1, verticesArr[v], e) != 0) {
                           
                           if (smallestDistance[u] + weight(forCopy1, verticesArr[v], e) < smallestDistance[v]) {
                                //update the smallest distance 
                                smallestDistance[v] = smallestDistance[u] + weight(forCopy1, verticesArr[v], e);
                                
                                // Update the path too
                                if (path[u] != null) {
                                 path[v] = path[u] + (char) (v + 65) ;
                                }
//                                else {
//                                path[v] = path[u] + (char) (v + 65) ;
//                                //System.out.println( path[v]);
//                                }
                                
                               
                                
                                
                                // Add edge to the result
                            }
                        }
                    }
                }
            }
        }
        
        
        
        //update all the vertices smallestDistance as infinity
        for (int i = 0; i < numVertices; i++) {
            if (i >= source) {
                verticesArr[i].setIsVisited(false);
            }
        }
        
        
        displayShortestPath();
        
        
        
        
        
        
        
        
        
//        // Print
//        for (int i = 0; i < verticesArr.length; i++) {
//            if (i >= source){
//                
//                String label = verticesArr[i].getLabel();
//                
//                if (path[i] != null) {
//                    for (int j = 0; j < path[i].length(); j++) {
//                        System.out.print("loc. "+ path[i].charAt(j)+ ": city " + (j+1) + " ");
//                    }
//                    
//                    System.out.print("--- route length: ");
//                
//                    if (smallestDistance[i] == infinity || smallestDistance[i] == 0) {
//                            System.out.println("No path");
//                        } 
//                    else {
//                        System.out.println(smallestDistance[i]);
//                    }    
//                }
//            }
//        }
//        System.out.println("\n--------------------------------------------------------------- \n" );
                       
    }
    
    
    public int weight(Vertex u, Vertex v, ArrayList<Edge> edges) {
        for (int i = 0; i < u.getAdjList().size(); i++) {
            if (u.getAdjList().get(i).getTarget().getLabel().equals(v.getLabel())) {
                //result.add((u.getAdjList().get(i)));
                return u.getAdjList().get(i).getWeight();
            }
        }
        return 0;
    }
    
    
    public void displayResultingMST(Vertex source) {
        
        System.out.print("The Starting point location is: ");
        System.out.println(source.getLabel());
        
        // Initialize a list to store the routes
        ArrayList<Route> routes = new ArrayList<>();
        for (int i = 0; i < graph.edges.size(); i++) {
            if (graph.edges.get(i) instanceof Route) {
                routes.add((Route) graph.edges.get(i));
            }
        }
        // Sort the routes based on weights
        Collections.sort(routes, Comparator.comparingInt(r -> r.getWeight()));

        Location location = new Location("A", "City");

        for (Route route : routes) {
            System.out.print("loc. " + route.getSource().getLabel() + ": " + location.getCity());
            System.out.print(" - loc. " + route.getTarget().getLabel() + ": " + location.getCity());
            System.out.println(" --- route length " + route.getWeight());
        }

    }

    @Override
    public void displayShortestPath() {
        
    for (int i = 0; i < verArray.length; i++) {
            if (i >= srcc){
                
                String label = verArray[i].getLabel();
                
                if (path[i] != null) {
                    for (int j = 0; j < path[i].length(); j++) {
                        System.out.print("loc. "+ path[i].charAt(j)+ ": city " + (j+1) + " ");
                    }
                    
                    System.out.print("--- route length: ");
                
                    if (smallestDistance[i] == Integer.MAX_VALUE || smallestDistance[i] == 0) {
                            System.out.println("No path");
                        } 
                    else {
                        System.out.println(smallestDistance[i]);
                    }    
                }
            }
        }
        System.out.println("\n--------------------------------------------------------------- \n" );
                       
    
    }
    
    
}
