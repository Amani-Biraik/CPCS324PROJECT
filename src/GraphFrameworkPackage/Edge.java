
package GraphFrameworkPackage;


public class Edge implements Comparable{
    // declare attributes
    private Vertex source;
    private Vertex target;
    private int weight;

    // constructer
    public Edge() {    
    }

    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
    
    

    // setters and getters
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }

    
    // display information
    public void displayInfo(){};
    
    @Override
    public int compareTo(Object t) {
        int compareweight=((Edge)t).getWeight();
        return this.weight-compareweight;
    }
    
    
}
