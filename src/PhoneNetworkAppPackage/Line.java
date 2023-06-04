
package PhoneNetworkAppPackage;

import GraphFrameworkPackage.Edge;


public class Line extends Edge{
    
    // declare attributes
    private int Ilength;

    // constructer
    public Line(int Ilength) {
        this.Ilength = Ilength;
    }
    
    // setter

    public void setIlength(int Ilength) {
        this.Ilength = Ilength;
    }

    public int getIlength() {
        return Ilength;
    }
     
    // Override display information

    @Override
    public void displayInfo() {
        System.out.println("line length: " + getIlength());
    }
    
    
}
