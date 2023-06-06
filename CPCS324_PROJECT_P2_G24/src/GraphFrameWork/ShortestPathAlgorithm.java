package GraphFrameWork;

public abstract class ShortestPathAlgorithm {
    public static Edge[] shortestPath;
    
    protected Graph graph;
    
    
    public ShortestPathAlgorithm(Graph graph){
        this.graph = graph;
    } 
    
    // Constructor 
    public ShortestPathAlgorithm() {}
   

    // Getters
    public static Edge[] shortestPath() {
        return shortestPath;
    }
    
     public Graph getGraph() {
        return graph;
    }

    //Display the result
    public abstract void displayShortestPath();
}
