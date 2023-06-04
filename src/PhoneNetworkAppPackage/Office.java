
package PhoneNetworkAppPackage;

import GraphFrameworkPackage.Vertex;


public class Office extends Vertex{


    // constructer
    public Office() {
    }
    
    // Override display information

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void displayInfo() {
        System.out.print("Office No. " + getLabel());
    }
    
    
    
    
}
