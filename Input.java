import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name: ");
        String name = scanner.nextLine();

        System.out.println("What is your age");
        
        int age  = 8;
        try {
            age = scanner.nextInt();
            int divide = age /0;

            System.out.println(divide);
            
        } catch (Exception e) {
            System.out.println("What you provided is not correct");
            scanner.nextLine(); 
        } finally {
            scanner.close(); 
        }

        int multiply = age * 5;

        System.out.println("Your name is " + name + " and you are " + age + " yeasrs old");

        scanner.close();
    }
}
