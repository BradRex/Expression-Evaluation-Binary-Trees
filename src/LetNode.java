import java.util.TreeMap;

//LetNode extends ExpTree which represents a node with the identifier-value pairs in the left child and the equation in
//the right child
public class LetNode extends ExpTree {

    //Instantiates the ExpTree TreeMap to be used to store id-value pairs and calls addIDs to add the id-value pairs.
    public LetNode(ExpTree leftChild, ExpTree rightChild) {
        identifiers = new TreeMap<>();
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        addIDs(leftChild);
    }

    //Searches the left child of the LetNode and finds id-value pairs and adds them to the ExpTree TreeMap
    public void addIDs(ExpTree tree) {
        if(tree instanceof EqualsNode){identifiers.put(((EqualsNode) tree).id, tree.leftChild);}
        else {
            addIDs(tree.leftChild);
            addIDs(tree.rightChild);
        }
    }

    //Calls the eval method on the right child (the equation) and returns the result
    public int eval() {return rightChild.eval();}

    //Returns the post-order string representation of the equation in the right child.
    public String asString() {
        return rightChild.asString();
    }

    //Returns the in-order string representation of the left and right children.
    public String toString() {
        return "let " + leftChild.toString() + " in " + rightChild.toString();
    }
}