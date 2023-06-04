/* Team members:
        1. Amani Khalid Biraik - B8 - 2006870
        2. Logain Ezzat Sendi - B0A - 2005341
        3. Gaidaa Al-shareef - B9B - 2005372
        4. Raghad Somily - B9A - 2105119
**/
package PhoneNetworkAppPackage;

import GraphFrameworkPackage.KruskalAlg;
import GraphFrameworkPackage.MHPrimAlg;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneNWDesignApp {

    // creating objects
    static public BluePrintsGraph PhLNetwork = new BluePrintsGraph();
    static public KruskalAlg KruskalPhLNetwork = new KruskalAlg();
    static public MHPrimAlg MHPrimPhLNetwork = new MHPrimAlg();

    public static void main(String[] args) throws FileNotFoundException {

        // create new file
        File graphFile = new File("graph.txt");

        // chack if file exists
        if (!graphFile.exists()) {
            System.out.println("File " + graphFile + " is not found!!");
            System.exit(0);
        }

        // create scanner object
        Scanner readFile = new Scanner(graphFile);
        Scanner read = new Scanner(System.in);

        System.out.println("\t\t************************************************************************************************************");
        System.out.println("\t\t*  Test to compute the minimum spanning tree, print it using the kruskal and priority queue based prim     * "
                + "\n\t\t*         algorithms, and perform an experimental comparison of these two algorithms.                      *");
        System.out.println("\t\t************************************************************************************************************\n");

        System.out.println("\t\t                    << (1) Requirement 1 Using readGraphFromFile Function >>");
        System.out.println("\t\t                    << (2) Requirement 2 Using MakeGraph Function         >>\n");

        System.out.print("\nSelect Requirement Option --> ");
        int option = read.nextInt();

        if (option == 1) {
            System.out.println("\n\t\t                         {Requirement 1 Using readGraphFromFile Function}\n\n");

            // read the graph from file
            PhLNetwork.readGraphFromFile(graphFile, readFile);

            //Apply kruskal Algorithm
            KruskalPhLNetwork.applyKruskalAlg(PhLNetwork);

            // display results of kruskal algorithm
            KruskalPhLNetwork.displayResultingMST(1);

            // apply priority queue based prim algorithm
            MHPrimPhLNetwork.applyMHPrim(PhLNetwork);

            //display result of prims algorithm
            MHPrimPhLNetwork.displayResultingMST(1);

            System.out.println("\nBuild Successful.\n");

        } else if (option == 2) {
            System.out.println("\n\t\t                         {Requirement 2 Using MakeGraph Function}\n\n");
            System.out.println("Cases of Vertices (n) and Edges (m)");
            System.out.println("(1) n= 1000  , m= 10000\n(2) n= 1000  , m= 15000\n(3) n= 1000  , m= 25000");
            System.out.println("(4) n= 5000  , m= 15000\n(5) n= 1000  , m= 25000");
            System.out.println("(6) n= 10000 , m= 15000\n(7) n= 10000 , m= 25000");
            System.out.print("\n");
            System.out.print("Select your Test Option -> ");
            int caseChoice = read.nextInt();
            System.out.print("\n");
            int verticesNo = 0;
            int edgesNo = 0;

            switch (caseChoice) {
                case 1: {
                    verticesNo = 1000;
                    edgesNo = 10000;
                    // Make a random graph
                    PhLNetwork.makeGraph(verticesNo, edgesNo, 0);
                }
                break;

                case 2: {
                    verticesNo = 1000;
                    edgesNo = 15000;
                    // Make a random graph
                    PhLNetwork.makeGraph(verticesNo, edgesNo, 0);
                }
                break;

                case 3: {
                    verticesNo = 1000;
                    edgesNo = 25000;
                    // Make a random graph
                    PhLNetwork.makeGraph(verticesNo, edgesNo, 0);
                }
                break;

                case 4: {
                    verticesNo = 5000;
                    edgesNo = 15000;
                    // Make a random graph
                    PhLNetwork.makeGraph(verticesNo, edgesNo, 0);
                }
                break;

                case 5: {
                    verticesNo = 5000;
                    edgesNo = 25000;
                    // Make a random graph
                    PhLNetwork.makeGraph(verticesNo, edgesNo, 0);
                }
                break;

                case 6: {
                    verticesNo = 10000;
                    edgesNo = 15000;
                    // Make a random graph
                    PhLNetwork.makeGraph(verticesNo, 15000, 0);
                }
                break;

                case 7: {
                    verticesNo = 10000;
                    edgesNo = 25000;
                    // Make a random graph
                    PhLNetwork.makeGraph(verticesNo, 25000, 0);
                }
                break;
            }

            //Apply kruskal Algorithm
            KruskalPhLNetwork.applyKruskalAlg(PhLNetwork);

            // display results of kruskal algorithm
            KruskalPhLNetwork.displayResultingMST(2);

            // apply min-heap based prim algorithm
            MHPrimPhLNetwork.applyMHPrim(PhLNetwork);

            //display result
            MHPrimPhLNetwork.displayResultingMST(2);

            System.out.println("\nBuild Successful.\n");

        }

    }

}
