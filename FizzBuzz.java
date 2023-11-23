import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {

        System.out.println("Give me a number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        for (int i = 1; i <= number; i++) {

            if(i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBUzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }
    }
}
