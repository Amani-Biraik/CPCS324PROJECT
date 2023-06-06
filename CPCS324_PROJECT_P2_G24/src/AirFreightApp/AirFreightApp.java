package AirFreightApp;

import GraphFrameWork.DBAllSourceSPAlg;
import GraphFrameWork.SingleSourceSPAlg;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class AirFreightApp {

    static public AFRouteMap graph = new AFRouteMap();
    static public DBAllSourceSPAlg allSource = new DBAllSourceSPAlg(graph);
    
    
    public static void main(String[] args) throws FileNotFoundException {
        int userInput = 0;
        boolean cond = true;
        int edgesNo=0, verticesNo=0;
        
        // Generate a random case from 1 to 5
        Random rand = new Random();
        int UrChoice = rand.nextInt((5 - 1) + 1) + 1;
        
        // create new file
        File graphFile = new File("graph.txt");
        
        
        // chack if file exists
        if (!graphFile.exists()) {
                System.out.println("File " + graphFile + " is not found!!");
                System.exit(0);
        }
        
        
        // create scanner object
        Scanner readFile = new Scanner(graphFile);
        Scanner in = new Scanner (System.in);
        
        while (cond) {
            // welcoming msg
            System.out.print("\t\t************************************************************************************************************\n" +
                                "\t\t**************** Test to compute the shortest path, print it using the Dijkstra algorithm *****************"
                            + "\n\t\t                 and perform an experimental comparison of the algorithms.                          \n" 
                            + "\t\t************************************************************************************************************\n\n"

                            + "\t\t                    << (1) Requirement 1 Using readGraphFromFile Function >>\n"
                            + "\t\t                    << (2) Requirement 2 Using MakeGraph Function         >>\n\n"

                            + "\nSelect Requirement Option --> ");
            
            userInput = in.nextInt();
             
            if (userInput == 1) {
               System.out.println("\n\t\t                         {Requirement 1 Using readGraphFromFile Function}\n\n"); 

               // Read the graph from the file
               graph.readGraphFromFile(graphFile, readFile);
               

               // Apply Dijkstra algorithm for single source
               long StartTime = System.currentTimeMillis();
               allSource.computeDijkstraBasedSPAlg(graph.verticesNo, graph.vertices, graph.edges);
               
               long Endtime = System.currentTimeMillis();
               long totalTime = Endtime - StartTime;
               
               System.out.println("Total runtime: " + totalTime);

               
               // Change the condition to exit the program
               cond = false; 
            }
            
            
            else if (userInput == 2) {
                switch (UrChoice) {
                    case 1: {
                         edgesNo = 2000;
                         verticesNo = 10000;
                         graph.makeGraph(2000, 10000, 1);
                    } break;
                    
                    case 2: {
                         edgesNo = 3000;
                         verticesNo = 15000;
                         graph.makeGraph(3000, 15000, 1);
                    } break;
                    
                    case 3: {
                         edgesNo = 4000;
                         verticesNo = 20000;
                         graph.makeGraph(4000, 20000, 1);
                    } break;
                    
                    case 4: {
                         edgesNo = 5000;
                         verticesNo = 25000;
                         graph.makeGraph(5000, 25000, 1);
                    } break;
                    
                    case 5: {
                         edgesNo = 6000;
                         verticesNo = 30000;
                         graph.makeGraph(6000, 30000, 1);
                    } break;
                }
                
                
               long StartTime = System.currentTimeMillis();
               allSource.computeDijkstraBasedSPAlg(graph.verticesNo, graph.vertices, graph.edges);
               long Endtime = System.currentTimeMillis();
               long totalTime = Endtime - StartTime;
               
               
               System.out.println("Total runtime: " + totalTime);

               // Change the condition to exit the program
               cond = false;
            }
            
            

            else {
               System.out.println("Wrong choice, please try again\n\n");
            }
        }
    }
}
