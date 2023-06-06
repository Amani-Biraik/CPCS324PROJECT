package AirFreightApp;

import GraphFrameWork.Edge;

public class Route extends Edge{
    // declare attributes
    private int Ilength;

    // constructer
    public Route(int Ilength) {
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
        System.out.println("Line length: " + getIlength());
    }
    
    
}
