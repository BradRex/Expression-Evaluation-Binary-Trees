public class EqualsNode extends ExpTree {
    protected char id;

    public EqualsNode(char id, ExpTree leftChild) {
        this.id = id;
        this.leftChild = leftChild;
    }

    public int eval() {
        return 0;
    }

    public String asString() {
        return "";
    }

    public String toString() {
        return id + " = " + leftChild.toString();
    }
}
