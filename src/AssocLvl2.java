//Abstract class AssocLvl2 extends OpNode and is a separate parent class for the Times, Divide and Mod Nodes.
//This makes it easier to identify the precedence of the operator using 'instanceof'
public abstract class AssocLvl2 extends OpNode {

    //Constructor calls the constructor of the OpNode class.
    public AssocLvl2() {
        super();
    }

    //Provides a string representation of its children in-order. Adds brackets where necessary based on the child's type
    public String toString() {
        String leftSide, rightSide;

        if(leftChild instanceof AssocLvl1) {
            leftSide = "(" + leftChild.toString() + ")";
        }
        else {
            leftSide = leftChild.toString();
        }

        if(rightChild instanceof AssocLvl1 || rightChild instanceof AssocLvl2) {
            rightSide = "(" + rightChild.toString() + ")";
        }
        else {
            rightSide = rightChild.toString();
        }

        return leftSide + value + rightSide;
    }
}

//TimesNode class extends AssocLvl2 and represents a Times operator node.
class TimesNode extends AssocLvl2 {

    public TimesNode(ExpTree leftChild, ExpTree rightChild) {
        super();
        value = '*';
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    //Returns the value of multiplying the two children's values together.
    public int eval() {
        return leftChild.eval() * rightChild.eval();
    }
}

//DivideNode class extends AssocLvl2 and represents a Divide operator node.
class DivideNode extends AssocLvl2 {

    public DivideNode(ExpTree leftChild, ExpTree rightChild) {
        super();
        value = '/';
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    //Returns the value of integer dividing the left child's value by the right child's value.
    public int eval() {
        return leftChild.eval() / rightChild.eval();
    }
}

//ModNode class extends AssocLvl2 and represents a Modulus operator node.
class ModNode extends AssocLvl2 {

    public ModNode(ExpTree leftChild, ExpTree rightChild) {
        super();
        value = '%';
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    //Returns the value of modulus dividing the left child's value by the right child's value.
    public int eval() {
        return leftChild.eval() % rightChild.eval();
    }
}