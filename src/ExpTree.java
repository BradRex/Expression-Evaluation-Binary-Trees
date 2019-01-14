import java.util.TreeMap;

//Abstract class ExpTree with two additional ExpTrees as left and right children.
public abstract class ExpTree {
    //TreeMap to map identifiers to their respective values.
    //The key is the character of the identifier and the value is an ExpTree.
    //identifiers will be null if there are no identifiers provided.
    protected static TreeMap<Character, ExpTree> identifiers;
    //left and right children who are themselves ExpTrees. Will be null if the ExpTree is a leaf i.e. num or id node
    protected ExpTree leftChild, rightChild;

    //Constructor sets the map to be null.
    public ExpTree() {
        if(identifiers != null){identifiers = null;}
    }

    //Declares abstract eval method which returns an int.
    public abstract int eval();

    //Declares abstract asString method which returns a string representing the equation as post-order.
    public abstract String asString();

    //Declares abstract toString method which return a string representing the equation in-order.
    public abstract String toString();
}