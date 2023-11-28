
import java.util.*;
// import java.util.ArrayList;

enum weekdays {
    Friday
}

public class DataTypes {
    public static void main(String[] args) {
        // boolean isReady = false;
        // char character = 'A';
        // short year = 2023;
        // int age = 12;
        // long phone = 34L;
        // byte noOFInClass = 23;

        // double accountBalance = 1234.23;
        // float remainder = (5/2);

        Integer five = 37;
        String s = new String("How are you?");
        int[] numbers = { 3, 1, 4, 9 };
        weekdays Friday = weekdays.Friday;
        ArrayList<String> fruits = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("20");

        // System.out.println("Is Ready is " + isReady);
        // System.out.println("The year is " + year);
        // System.out.println("Character is " + character);
        // System.out.println("Your age is " + age);
        // System.out.println("Phone is " + phone);
        // System.out.println("Remainder is " + remainder);
        // System.out.println("Class number is " + noOFInClass);
        // System.out.println("Your account balance is " + accountBalance);

        System.out.println("Your Integer value is " + five);
        System.out.println("Hello Temitope, " + s);
        System.out.println("Array is " + numbers);
        System.out.println("Your list is " + fruits);
        System.out.println("Your list is " + list);
        System.out.println("Today is " + Friday);

        System.out.println("Number of fruits is " + fruits.size());

        System.out.println("The Second fruit is " + fruits.get(1));

        fruits.set(0, "Mango");
        System.out.println(fruits);

        for (String fruit : fruits) {
            System.out.println(fruit);

        }
        fruits.clear();
        System.out.println("Number of fruits after clearing is: " + fruits.size());

    }

}
