public class MethodsAndFunctions {

    public static void main(String[] args) {
        String name = "Alice";

        greetPerson(name); // Calls the greetPerson method

        int result = multiply(5, 3); // Calls the multiply method and captures the result
    }


    // Method declaration with a return type (int)
    int add(int a, int b) {
        return a + b;
    }

    // instance Method declaration with no return value (void)
    private void printMessage(String message) {
        System.out.println(message);
    }

    // static Method with a string parameter
    private static void greetPerson(String name) {
        System.out.println("Hello, " + name);
    }

    // Method with 2 int parameter
    private static int multiply(int x, int y) {
        return x * y;
    }

    // method overload
    double add(double c, double d) {
        return c + d;
    }

}
