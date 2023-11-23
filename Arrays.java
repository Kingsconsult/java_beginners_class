import java.util.ArrayList;

public class Arrays {


    public static void main(String[] args) {

        String[] shoes = new String[5];

        int[] myNum = { 10, 20, 30, 40 };
        String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };

        System.out.println(cars[0]);

        System.out.println(shoes.length);

        // loop through using for loop
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        // loop through using for each
        for (String i : cars) {
            System.out.println(i);
        }
    }

	public static String[] toString(ArrayList<String> fruits) {
		return null;
	}
}
