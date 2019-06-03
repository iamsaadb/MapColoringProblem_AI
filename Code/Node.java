
// Node class, node(id,color,nEdges and nextNode)
public class Node {
    public int id;
    public int color;
    public int numEdges;
    Node next;
        
    public Node (int nodeID){
        id=nodeID;
        numEdges=0;
        color=0;
        next=null;

    }
}
