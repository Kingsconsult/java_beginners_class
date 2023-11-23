public class AssignmentOperators {
    
    public static void main(String[] args) {

        int x = 3;
        
        int addition = x += 3;               //   x = 3;
        int subtraction = x -= 3;            //   x = 3;
        int multiplication = x *= 3;         //   x = 3;
        double division = x /= 3;            //   x = 3;
        int modulus = x %= 3;                //   x = 3;
        int bitwiseAnd = x &= 3;             //   x = 3;
        int bitwiseOR = x |= 3;              //   x = 3;
        int bitwiseXOR = x ^= 3;             //   x = 16;
        int bitwiseRight = x >>= 2;          //   x = 16;
        int bitwiseLeft = x <<= 2; 

        System.out.println("This is the result for addition " + addition);
        System.out.println("This is the result for subtraction " + subtraction);
        System.out.println("This is the result for multiplication " + multiplication);
        System.out.println("This is the result for division " + division);
        System.out.println("This is the result for modulus " + modulus);
        System.out.println("This is the result for bitwiseAnd " + bitwiseAnd);
        System.out.println("This is the result for bitwiseOR " + bitwiseOR);
        System.out.println("This is the result for raise " + bitwiseXOR);
        System.out.println("This is the result for bitwiseRight " + bitwiseRight);
        System.out.println("This is the result for bitwiseLeft " + bitwiseLeft);
	}
}
