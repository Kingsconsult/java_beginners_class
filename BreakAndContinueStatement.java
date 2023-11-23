public class BreakAndContinueStatement {
    
    public static void main(String[] args) {


        // break statement
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; // Exit the loop when i equals 5
            }
            System.out.println("break Value of i: " + i);
        }

        System.out.println();
        
        // continue statement
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // Skip iteration when i equals 3
            }
            System.out.println("continue Value of i: " + i);
        }
        

    }
}
