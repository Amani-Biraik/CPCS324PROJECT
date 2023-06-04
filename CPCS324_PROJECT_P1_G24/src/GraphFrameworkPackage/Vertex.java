
package GraphFrameworkPackage;

import java.util.ArrayList;


public class Vertex {
    // declaring the attributes
    private ArrayList<Edge> adjList = new ArrayList<>();
    public String label; // number represents the vertex label
    private boolean isVisited = false;
    private int position; // to determine the position of the vertex in the vertices array
    
    //Constructor
    public Vertex() {
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

    public void setPosition(int position) {
        this.position = position;
    }
 

    public ArrayList<Edge> getAdjList() {
        return adjList;
    }

    public String getLabel() {
        return label;
    }

    public int getPosition() {
        return position;
    }
    

    public boolean isIsVisited() {
        return isVisited;
    }
    
    // display information
    public void displayInfo(){}
}
