//AndNode extends ExpTree and holds two EqualsNodes/AndNodes as its children.
public class AndNode extends ExpTree {

    //Constructor assigns the values of the left and right children
    public AndNode(ExpTree leftChild, ExpTree rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    //Doesn't have a value so returns a default value of 0. Won't be called.
    public int eval() {
        return 0;
    }

    //Doesn't have a value for post-order. Returns an empty string.
    public String asString() {
        return "";
    }

    //Returns the value of the left and right children.
    public String toString() {
        return leftChild.toString() + " and " + rightChild.toString();
    }
}