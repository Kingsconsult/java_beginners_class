public class Comparison {
    public static void main (String[] args) {

        int x = 4;
        // int y = 7;

        


        // LOGICAL

        boolean logicalAnd = x < 5 && x < 10;
        boolean logicalOr = x < 5 || x < 10;
        boolean logicalNot = !(x < 5 || x < 10);

        System.out.println("This is the result for logicalAnd " + logicalAnd);
        System.out.println("This is the result for logicalOr " + logicalOr);
        System.out.println("This is the result for logicalNot " + logicalNot);

    }
}
