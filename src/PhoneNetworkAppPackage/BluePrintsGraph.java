
package PhoneNetworkAppPackage;

import GraphFrameworkPackage.Edge;
import GraphFrameworkPackage.Graph;
import GraphFrameworkPackage.Vertex;
import java.io.File;


public class BluePrintsGraph extends Graph{

    public BluePrintsGraph() {
    }

    @Override
    public Vertex createVertex() {
        return new Office();
    }

    @Override
    public Edge createEdge(int Ilength) {
        return new Line(Ilength);
    }
    
    
   
    
    
    
    
    
}
