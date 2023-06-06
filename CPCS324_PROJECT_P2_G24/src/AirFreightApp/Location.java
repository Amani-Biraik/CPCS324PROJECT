package AirFreightApp;

import GraphFrameWork.Vertex;

public class Location extends Vertex {
    public String city;
    
    // constructer
    public Location() {
    }

    public Location(String city) {
        this.city = city;
    }

    public Location(String a, String city) {
        
    }

    public String getCity() {
        return city;
    } 

    // Getters and Setters
    public void setCity(String city) {
        this.city = city;
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
