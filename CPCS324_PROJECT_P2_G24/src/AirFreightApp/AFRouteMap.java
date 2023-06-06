package AirFreightApp;

import GraphFrameWork.Graph;
import GraphFrameWork.Vertex;
import GraphFrameWork.Edge;

public class AFRouteMap extends Graph {
    
    public AFRouteMap() {
    }
    
    public AFRouteMap(int verticesNo, int edgeNo, boolean isDigrph) {
       this.verticesNo = verticesNo;
       this.edgeNo = edgeNo;
       this.isDigrph = isDigrph;
       vertices = new Vertex[verticesNo];      
   }
       

    @Override
    public Edge createEdge(int length) {
        return new Route(length);
    }

    @Override
    public Vertex createVertex() {
        return new Location();
    }
    
    

    
    
    
    
}
