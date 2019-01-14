//Ass2 contains main() method for running assignment 2.
public class Ass2 {
    public static void main(String[] args) {
        System.out.println("Bradley Rex, 1504843." +
                "\nWelcome to Brad's expression evaluation program.");

        Parser parser = new Parser();
        //ExpTree object holds the ExpTree created from the user's expression
        ExpTree myTree;
        //String object holds the users choice. Used in the interactive loop.
        String choice;

        /*Takes the users input and attempts to create an expression tree.
         *If successful, will display the post-order and in-order representation of the expression as well as the value
         *of the expression.
         *Otherwise, reports the error to the user.
         *In either case, the user is then asked if they would like to enter another expression.*/
        do {
            System.out.println("Please type an expression:");

            try {
                myTree = parser.parseLine();
                System.out.println("Post-order: " + myTree.asString());

                System.out.println("In-order: " + myTree.toString());

                System.out.println("Tree Evaluation: " + myTree.eval());
            }
            catch(ParseException e1) {
                System.out.println(e1.getMessage());
            }
            catch(Exception e2) {
                System.out.println("ERROR: " + e2.getMessage());
            }

            System.out.println("Another expression (y/n)?");
            choice = parser.getLine();
        }
        while(choice.equals("y"));
    }
}