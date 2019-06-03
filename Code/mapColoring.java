import java.io.PrintWriter;
import java.util.Scanner;

public class mapColoring {

    private int[][] adjacencyMatrix;
    private Node listHead;
    private Node currentNode;
    private int uncoloredNode;
    private int newColor;
    private int totalNodes;
    private Scanner inputf;
    private PrintWriter outputf;

    public mapColoring (int totNodes, Scanner input_file, PrintWriter output_file){
        totalNodes=totNodes;
        inputf = input_file;
        outputf = output_file;
        listHead = new Node(-1);
        adjacencyMatrix = new int[totalNodes+1][totalNodes+1];
        newColor=0;
    }

    public void start(){
       // Load Adj Matrix, Print it and Extract Asc Node List.
        loadAdjacencyMatrix();
        printAdjacencyMatrix();
        constructNodeList(listHead);

        while (!allNodesAreColored()) {
       // Initialize color and start from less constraining node in the list (Head)
            newColor++;
            currentNode = listHead.next;
       //for every node check the color of the node, check the neighbors' colors if diff, affect color
       //and move to the next node
            do {
                if (currentNode.color == 0 && checkAdjacent(currentNode.id, newColor)) {
                    adjacencyMatrix[currentNode.id][currentNode.id] = newColor;
                    currentNode.color = newColor;
                }
                currentNode = currentNode.next;
            } while (currentNode != null);
        // repeat the do-while until the end of node list
        }
        // repeat "backtracking"  until all nodes have a color
        // print adjacencyMatrix with the colors in the diagonal
        outputf.println("\n To color the map, you need: "+newColor + "colors");
        printAdjacencyMatrix();

    }

    

    private void insertOneNodeInAscOrder (Node listhead, Node newNode){
        Node trav = listhead;
        if (listhead.next==null){
            listhead.next=newNode;
        }
        else {
            while (trav.next !=null && newNode.numEdges > trav.next.numEdges) {
                trav = trav.next;
            }
            newNode.next = trav.next;
            trav.next = newNode;
        }
    }

    private void constructNodeList (Node listhead) {
        Node node=null;
        for (int i=1; i<totalNodes+1; i++){
            node = new Node(i); 
                //make new node object for each number in matrix
            for (int j=1; j<totalNodes+1; j++){
                //increment edge every time the value is 1
                if (adjacencyMatrix[i][j]==1){
                    node.numEdges++;
                }
            }
            //insert new node
            insertOneNodeInAscOrder(listHead, node);
        }
    }
    private void loadAdjacencyMatrix(){
        int i, j;
        while (inputf.hasNext()){
            i=inputf.nextInt();
            outputf.print(i+" ");
            j=inputf.nextInt();
            outputf.println(j); 
            //print input pairs to outfile to satisfy output requirement
            adjacencyMatrix[i][j]=1;
            adjacencyMatrix[j][i]=1;
        }
    }
    
    //funtion to check whether the node shares the same color with its adjacents 
    private boolean checkAdjacent (int nodeID, int nodeColor){
        // if adjacent have same color --> true, else --> false
        boolean unmatchingColors=true;
        for (int i=1; i<totalNodes+1; i++){
            if (adjacencyMatrix[nodeID][i]==1){
                if (adjacencyMatrix[i][i]==nodeColor){
                    unmatchingColors=false;
                }
            }
        }
        return unmatchingColors;
    }

    //boolean to check if all nodes are assigned a color
    private boolean allNodesAreColored (){
        boolean allColored=true;
        for (int i=1; i<totalNodes+1; i++){
            if (adjacencyMatrix[i][i]==0){
                allColored=false;
            }
        }
        return allColored;
    }

    //Print matrix method
    private void printAdjacencyMatrix (){
        for (int i=1; i<totalNodes+1; i++){
            for (int j=1; j<totalNodes+1; j++){
                outputf.print(adjacencyMatrix[i][j]+" ");
            }
            outputf.println("");
        }
        outputf.println("");
    }
}
