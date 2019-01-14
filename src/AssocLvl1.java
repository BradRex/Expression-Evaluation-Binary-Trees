//Abstract class AssocLvl1 extends OpNode and is a separate parent class for the Plus and Minus Nodes.
//This makes it easier to identify the precedence of the operator using 'instanceof'
public abstract class AssocLvl1 extends OpNode {

    //Constructor calls the constructor of the OpNode class.
    public AssocLvl1() {
        super();
    }

    //Provides a string representation of its children in-order. Adds brackets where necessary based on the child's type
    public String toString() {
        String leftSide, rightSide;

        leftSide = leftChild.toString();

        if(rightChild instanceof AssocLvl1) {
            rightSide = "(" + rightChild.toString() + ")";
        }
        else {
            rightSide = rightChild.toString();
        }

        return leftSide + value + rightSide;
    }
}

//PlusNode class extends AssocLvl1 and represents a Plus operator node.
class PlusNode extends AssocLvl1 {

    public PlusNode(ExpTree leftChild, ExpTree rightChild) {
        super();
        value = '+';
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    //Returns the value of adding the two children's values together.
    public int eval() {
        return leftChild.eval() + rightChild.eval();
    }
}

//MinusNode class extends AssocLvl1 and represents a Minus operator node.
class MinusNode extends AssocLvl1 {

    public MinusNode(ExpTree leftChild, ExpTree rightChild) {
        super();
        value = '-';
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    //Returns the value of subtracting the right child's value from the left child's value.
    public int eval() {
        return leftChild.eval() - rightChild.eval();
    }
}