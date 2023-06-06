package GraphFrameWork;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Graph {
    public Vertex[] vertices;// list of vertices in the graph
    public ArrayList<Edge> edges = new ArrayList<>();
    public int verticesNo;// should be incremented whenever a new vertex is added to the graph
    public int edgeNo; // number of edges in the graph
    public boolean isDigrph; // true: if graph is directed
    public int totalEdgesNo;
    public ArrayList<String> labels = new ArrayList<>();

    
    
    //constructers
    public Graph() {
    }

    public Graph(int verticesNo, int edgeNo, boolean isDigrph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigrph = isDigrph;
        vertices = new Vertex[verticesNo];      
    }
    
    // setter and getter function
    public void setVerticesNo(int verticesNo) {
        this.verticesNo = verticesNo;
    }

    public void setEdgeNo(int edgeNo) {
        this.edgeNo = edgeNo;
    }

    public void setIsDigrph(boolean isDigrph) {
        this.isDigrph = isDigrph;
    }

    public int getVerticesNo() {
        return verticesNo;
    }

    public int getEdgeNo() {
        return edgeNo;
    }

    public boolean isIsDigrph() {
        return isDigrph;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    

    
    // Read Graph From File function
    public void readGraphFromFile(File filename, Scanner read) {

        String graphType = read.next();
        int graphTypeNo = read.nextInt();
        isDigrph = true; // In this project the graph always directed

        int vertNo = read.nextInt();
        vertices = new Vertex[vertNo];

        int totaledgeNo = read.nextInt();
        verticesNo = 0;

        for (int i = 0; i < totaledgeNo; i++) {
            // read source vertex
            String v = read.next();
            // add vertex v
            Vertex sourceVertex = addVertex(v);
            
            // read target vertex 
            String u = read.next();
            // add vertex u
            Vertex targetVertex = addVertex(u);
            
            // read weight of the edge
            int w = read.nextInt();

            // pass source vertex , target vertex , and weight to the addEdge method
            addEdge(sourceVertex, targetVertex, w);
        }
    }
    
    
    // Make graph method
    // make graph function 
    public void makeGraph(int vertNo, int EdgeNo, int isDigraphNum) {
        // Create vertex array
        vertices = new Vertex[vertNo];

        // Determine the graph type (directed, undirected)
        if (isDigraphNum == 0) {
            this.isDigrph = false;
        } else if (isDigraphNum == 1) {
            this.isDigrph = true;
        }

        String randomLabel = "";
        // Create new Vertex object for all vertices in the graph, there labels are null initially
        for (int i = 0, j=1 ; i < vertNo; i++, j++) {
            // create a random label
            //randomLabel = createLabel();
            randomLabel = "O" + j;
            // add the vertex
            addVertex(randomLabel);
        }
        
//        for (int i = 0; i < vertNo; i++) {
//            System.out.println(vertices[i].getLabel());
//        }
//

        connectVerticesToEdgesRandomly(EdgeNo);
        
//        for (int i = 0; i < edges.size(); i++) {
//            System.out.print(edges.get(i).getSource().getLabel() + " ");
//            System.out.print(edges.get(i).getTarget().getLabel() + " ");
//            System.out.println(edges.get(i).getWeight());
//        }
        
    }
    
    
    
    // Add edge method
    public void addEdge(Vertex v, Vertex u, int w) {
        // Create a new edge and add it to the edges array
        edges.add(createEdge(w));
        edgeNo++;

        // add this edge to the adjacent list of the source vertex (v) and declare the target vertex (u) and weight
        v.setAdjList(edges.get(edgeNo - 1));
        edges.get(edgeNo - 1).setSource(v);
        edges.get(edgeNo - 1).setTarget(u);
        edges.get(edgeNo - 1).setWeight(w);
    }
    
    
    
    
    // Add vertex method
    public Vertex addVertex(String vertex) {

        // check if vertex already visited or exists in the vertices array then add the vertex if not
        int counter = 0;
        while (counter < vertices.length) {
            if (!(vertices[counter] == null)) {
                if (vertices[counter].getLabel().equals(vertex)) {
                    break;
                }
            } else {
                // add the vertex
                vertices[counter] = createVertex();
                vertices[counter].setLabel(vertex);
                verticesNo++; // increment the total number of vertices in the graph
                break;
            }
            counter++;
        }

        return vertices[counter];
    }
    
    
    
    
    // create vertex method
    public Vertex createVertex() {
        return null;
    }

    // create edge method
    public Edge createEdge(int Ilength) {
        return null;
    }
    
    
    
    
    
    
  public void connectVerticesToEdgesRandomly(int EdgeNo) {
        int totalEdgeNo = EdgeNo;
        Random random = new Random();
        ArrayList<Vertex> isConnected = new ArrayList<>();
        // choose randomly an index in vertices array and consider it as the source vertex, do the same thing for the target vertex
        int SourceIndex = random.nextInt(vertices.length);
        // The first loop is used to connect edges to vertices and make sure that ech vertex has atleast one edge connected to it 
        //and also make sure that the graph is connected
        while (true) {
            int targetIndex;
            // check if the target vertex is same as the source vertex vertex 
            while (true) {
                targetIndex = random.nextInt(vertices.length);
                if (!(vertices[SourceIndex].getLabel().equals(vertices[targetIndex].getLabel())) && !(isConnected.contains(vertices[targetIndex]))) {
                    break;
                }
            }

            // generate a random weight for the edge
            int weight = random.nextInt(40) + 1;

            addEdge(vertices[SourceIndex], vertices[targetIndex], weight);
            totalEdgeNo--;

            isConnected.add(vertices[SourceIndex]);
            SourceIndex = targetIndex;

            if (isConnected.size() == ((vertices.length)-1)) {
                break;
            }

        }

        // now each vertix in the graph is connected to atleast one edge
        // if there is any remaining edges not connected to the graph, then connect them to vertices randomly 
        if (totalEdgeNo != 0) {
            while (true) {
                SourceIndex = random.nextInt(vertices.length);
                int targetIndex;
                // check if the target vertex is not same as the source vertex and that there is no already existing edge between the source and target vertices
                while (true) {
                    targetIndex = random.nextInt(vertices.length);
                    if (!(vertices[SourceIndex].getLabel().equals(vertices[targetIndex].getLabel()))) {
                        // check if the edge we want to add between these two vertices is already exists by checking the adjacent list of the source vertex
                        boolean exists = false;
                        for (int j = 0; j < vertices[SourceIndex].getAdjList().size(); j++) {
                            if (vertices[targetIndex].getLabel().equals(vertices[SourceIndex].getAdjList().get(j).getTarget().getLabel())) {
                                exists = true;
                            }
                        }

                        if (!exists) {
                            break;
                        }
                    }

                }
                // generate a random weight for the edge
                int weight = random.nextInt(40) + 1;
                addEdge(vertices[SourceIndex], vertices[targetIndex], weight);
                totalEdgeNo--;
                
                if (totalEdgeNo == 0) {
                    break;
                }

            }

        }
    }  
    
    
    
}
