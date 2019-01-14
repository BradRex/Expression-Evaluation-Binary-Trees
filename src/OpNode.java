//Abstract class OpNode extends ExpTree and represents a branch node storing an operator
public abstract class OpNode extends ExpTree {
    //char variable stores the operator of the node
    protected char value;

    //Constructor calls the ExpTree class constructor
    public OpNode() {
        super();
    }

    //Returns a String representing the left child, right child and the operator value, hence producing the post-order
    //output.
    public String asString() {
        return leftChild.asString() + " " + rightChild.asString() + " " + value;
    }
}