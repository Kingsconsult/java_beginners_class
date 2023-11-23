public class ComparisonOperators {
    
    public static void main(String[] args) {

        int x = 15;
        int y = 3;

        boolean equalTo = x == y; 
        boolean notEqualTo = x != y; 
        boolean greaterThan = x > y; 
        boolean lessThan = x < y; 
        boolean greaterThanOrEqualTo = x >= y; 
        boolean lessThanOrEqualTo = x <= y; 

        System.out.println("This is the result for equalTo " + equalTo);
        System.out.println("This is the result for notEqualTo " + notEqualTo);
        System.out.println("This is the result for greaterThan " + greaterThan);
        System.out.println("This is the result for lessThan " + lessThan);
        System.out.println("This is the result for greaterThanOrEqualTo " + greaterThanOrEqualTo);
        System.out.println("This is the result for lessThanOrEqualTo " + lessThanOrEqualTo); 
	}
}
