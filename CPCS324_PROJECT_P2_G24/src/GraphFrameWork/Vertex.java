package GraphFrameWork;

import java.util.ArrayList;

public class Vertex {
    // declaring the attributes
    //private Edge[] adjList;
    public ArrayList<Edge> adjList = new ArrayList<>();
    public String label; // number represents the vertex label
    public boolean isVisited = false;
    
    //Constructor

    public Vertex() {
        this.label = null;
        adjList = new ArrayList<Edge>();
    }

    public Vertex(String label) {
        this.label = label;
        adjList = new ArrayList<Edge>();
    }

    // setters and getters

    public void setAdjList(Edge edge) {
        adjList.add(edge);
    }
    
    
    public void setLabel(String label) {
        this.label = label;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public ArrayList<Edge> getAdjList() {
        return adjList;
    }

    public String getLabel() {
        return label;
    }
    
    

    public boolean isIsVisited() {
        return isVisited;
    }
    
    // display information
    public void displayInfo(){}
}
   
