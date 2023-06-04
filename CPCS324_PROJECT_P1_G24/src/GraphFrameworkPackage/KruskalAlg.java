package GraphFrameworkPackage;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlg extends MSTAlgorithm {

    // inherited attributes
    private Graph graph;
    private ArrayList<Edge> MSTresultList = new ArrayList<>();
    // additional attribute
    private int totalCost = 0;
    long runTime;

    //constructer
    public KruskalAlg() {

    }

    // getter
    public int getTotalCost() {
        return totalCost;
    }

    public long getRunTime() {
        return runTime;
    }

    // applying kruskal algorithm on a given graph
    public void applyKruskalAlg(Graph graph) {

        // start time
        long startTime = System.currentTimeMillis();
        this.graph = graph;

        Vertex[] vertices = graph.getVertices();

        // sort the edges in the graph in ascending order
        ArrayList<Edge> EdgeList = graph.getEdges();
        Collections.sort(EdgeList);
        
        // remove repeated edges in case the graph is undirected
        if (graph.isIsDigrph() == false) {
            for (int i = EdgeList.size() - 1; i >= 0; i--) {
                if (i % 2 != 0) {
                    EdgeList.remove(i);
                }
            }
        }

        // make set for each vertex
        Vertex[] findDes = new Vertex[vertices.length];
        for (int i = 0; i < findDes.length; i++) {
            findDes[i] = new Vertex();
            findDes[i].setPosition(i);
        }

        int counter = 0;

        while (counter < graph.getVerticesNo()-1) {

            // get the minimum weight edge from eggelist 
            Edge minWedge = EdgeList.remove(0);
            Vertex SrcVert = minWedge.getSource();
            Vertex TrgVert = minWedge.getTarget();

            // find representitave sub set
            if (!findSet(findDes[SrcVert.getPosition()].getPosition(), findDes[TrgVert.getPosition()].getPosition())) {
                // (Union) connect SrcVert to TrgVert and their values
                union(findDes, SrcVert, TrgVert);
                
                MSTresultList.add(minWedge);
                totalCost = totalCost + minWedge.getWeight();
                
                counter++;
            }

            
        }

        // end time
        long endTime = System.currentTimeMillis();

        // calculate the run time
        runTime = endTime - startTime;

    }

    // find set method
    public boolean findSet(int v1, int v2) {
        return v1 == v2;
    }

    // Union method
    public void union(Vertex[] findDes, Vertex srcVert, Vertex TargVert) {
        // get source an target vertices representitaves
        int srcVertRepresentative = findDes[srcVert.getPosition()].getPosition();
        int TargVertRepresentative = findDes[TargVert.getPosition()].getPosition();

        // find if srcVert and TargVert have representative or not
        boolean srcVertNoRep = findSet(srcVert.getPosition(), srcVertRepresentative);
        boolean TargVertNoRep = findSet(TargVert.getPosition(), TargVertRepresentative);

        // Check if current srcVert and TargVert are representative of set 
        for (int i = 0; i < findDes.length; i++) {

            if (srcVertRepresentative == findDes[i].getPosition() && (i != srcVert.getPosition())) {
                srcVertNoRep = false;
            }

            if (TargVertRepresentative == findDes[i].getPosition() && (i != TargVert.getPosition())) {
                TargVertNoRep = false;
            }
        }

        // if srcVert have a representative and TargVert have NO representative OR srcVert and TargVert both have NO representative
        if (((!srcVertNoRep) && (TargVertNoRep)) || (srcVertNoRep && TargVertNoRep)) {

            findDes[srcVert.getPosition()] = findDes[srcVert.getPosition()];
            findDes[TargVert.getPosition()] = findDes[srcVert.getPosition()];

        } else if (srcVertNoRep && (!TargVertNoRep)) {
            findDes[srcVert.getPosition()] = findDes[TargVert.getPosition()];
        } else {

            int maxRepresentative = Math.max(srcVertRepresentative, TargVertRepresentative); // Get max representative to overwrite its children
            int minRepresentative = Math.min(srcVertRepresentative, TargVertRepresentative); // Get minimum to set it as the new representative

            // Loop through the QuickFind Disjoint Subset
            for (int i = 0; i < findDes.length; i++) {

                // Find all the children of the max representative
                if (findDes[i].getPosition() == maxRepresentative) {
                    findDes[i] = findDes[minRepresentative]; // Update all representatives to the minimum Representative

                } 
            } 
        }

    }

    @Override
    public void displayResultingMST(int requirementNum) {

        if (requirementNum == 1) {
            // print the result
            System.out.println("The phone network (minimum spanning tree) generated by kruskal algorithm is as follows:");

            for (int i = 0; i < MSTresultList.size(); i++) {

                Edge line = MSTresultList.get(i);

                Vertex sourceOffice = line.getSource();
                Vertex targetOffice = line.getTarget();

                sourceOffice.displayInfo();
                System.out.print(" - ");
                targetOffice.displayInfo();
                System.out.print(" : ");
                line.displayInfo();
            }

            System.out.println("The cost of designed phone network: " + getTotalCost());

        } else if (requirementNum == 2) {
            // print the result
            System.out.println("The phone network (minimum spanning tree) generated by kruskal algorithm is as follows:");
            System.out.println("The cost of designed phone network: " + getTotalCost());
            System.out.println("Run time: " + runTime + " milliseconds");

        }
    }

}
