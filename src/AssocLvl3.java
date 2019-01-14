//Abstract class AssocLvl3 extends OpNode and is a separate parent class for the Power Node.
//This makes it easier to identify the precedence of the operator using 'instanceof'
public abstract class AssocLvl3 extends OpNode {

    //Constructor calls the constructor of the OpNode class.
    public AssocLvl3() {
        super();
    }

    //Provides a string representation of its children in-order. Adds brackets where necessary based on the child's type
    public String toString() {
        String leftSide, rightSide;

        if(leftChild instanceof AssocLvl2 || leftChild instanceof AssocLvl3) {
            leftSide = "(" + leftChild.toString() + ")";
        }
        else {
            leftSide = leftChild.toString();
        }

        if(rightChild instanceof AssocLvl2) {
            rightSide = "(" + rightChild.toString() + ")";
        }
        else {
            rightSide = rightChild.toString();
        }

        return leftSide + value + rightSide;
    }
}

//PowerNode class extends AssocLvl3 and represents a Power operator node.
class PowerNode extends AssocLvl3 {

    public PowerNode(ExpTree leftChild, ExpTree rightChild) {
        super();
        value = '^';
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    //Returns the value of raising the left child's value to the power of the right child's value.
    //However, if the right child is negative then a NegativePowerException will be thrown.
    public int eval() {
        int rightEval = rightChild.eval();
        if (rightEval < 0) {
            throw new NegativePowerException();
        } else if (rightChild.eval() == 0) {
            return 0;
        } else {
            //Uses the pow method of the Math class to calculate the value.
            return (int) Math.pow(leftChild.eval(), rightEval);
        }
    }
}

//NegativePowerException extends RuntimeException allowing it to be thrown as an exception.
class NegativePowerException extends RuntimeException {
    //Constructor passes on the details of the exception in a call to its parent's constructor.
    public NegativePowerException() {
        super("Expression contains a negative power.");
    }
}