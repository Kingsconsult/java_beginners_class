import java.util.*;
// import java.util.List;


public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("20");
        System.out.println("Number of fruits: " + fruits.size());
        
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("Get the second fruit: " + fruits.get(1));

        fruits.set(0, "Orange");

        System.out.println("The first fruit is now: " + fruits.get(0));
      for (String fruit : fruits) {
            System.out.println(fruit);
        }
        fruits.clear();

        System.out.println("Number of fruits after clearing is: " + fruits.size());

        // System.out.println("One fruit will be remove: ");

    }
}
