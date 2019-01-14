//NumNode extends ExpTree and represents a leaf node storing a number
public class NumNode extends ExpTree {
    //int variable stores the numerical value of the num node
    private int value;

    //Constructor assigns the int passed and sets both the left and right children to null.
    public NumNode(int value) {
        super();
        this.value = value;
        leftChild = rightChild = null;
    }

    //Returns the numerical value of the node.
    public int eval() {
        return value;
    }

    //Returns the nodes value as a string
    public String asString() {
        return value + "";
    }

    //Returns the nodes value as a string
    public String toString() {
        return value + "";
    }
}