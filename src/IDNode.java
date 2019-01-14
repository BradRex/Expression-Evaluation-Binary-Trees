//IDNode extends ExpTree and represents a leaf node storing an ID char.
public class IDNode extends ExpTree {
    //char variable stores the ID of the node
    private char value;

    //Constructor assigns the char passed and sets both the left and right children to null.
    public IDNode(char value) {
        super();
        this.value = value;
        leftChild = rightChild = null;
    }

    //Calculates the value associated with the ID char either by finding it in the map or using the assumption A=26, Z=1
    //And returns the int value.
    public int eval() {
        if (identifiers == null) {
            return 26 - (value - 'A');
        }
        else {
            if (identifiers.containsKey(value)) {
                return identifiers.get(value).eval();
            }
            else {
                System.out.println(value + " not defined. Given default value 0.");
                return 0;
            }
        }
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