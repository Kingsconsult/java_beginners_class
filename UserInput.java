import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name:");
        String name = scanner.nextLine();
        


        System.out.println("What is your age:");
 
        int age;
        try{
            age = scanner.nextInt();
            // int divide = age / 0;
            // System.out.println(divide);

        } catch (InputMismatchException e){
            System.out.println("What you provided is not correct");
            scanner.nextLine();
            
        } finally{
            age = scanner.nextInt();
        }

        scanner.close();
        System.out.println("Your name is " + name + " and your age is " + age + ".");

    }
}