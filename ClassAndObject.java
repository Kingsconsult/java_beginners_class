public class ClassAndObject {

    public static void main(String[] args) {

        // Create objects
        Car myCar = new Car("Toyota", "Camry");
        Car yourCar = new Car("Honda", "Civic");

        Car.stop();
        Car ecobankCar = new Car("Tech", "Civic", "blue");
        ecobankCar.start();
        ecobankCar.move("I am moving");
        // Access attributes and methods
        System.out.println("My car is a " + myCar.make + " " + myCar.model);
        System.out.println("My other car is a " + yourCar.make + " " + yourCar.model);
        myCar.start();
        myCar.move("My car is moving");
        yourCar.start();

    }

}

class Car {

    // Attributes
    String make;
    String model;
    String color;

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    
    // Constructor
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public static void stop()
    {
        System.out.println("I have stopped");
    }

    public Car (String make, String model, String color) {
       this.make = make;
        this.model = model;
        this.color = color;
    }

    public void move(String move) {
        System.out.println(move);
    }

    // Method
    public void start() {
        System.out.println("The " + this.make + " " + this.model + " is starting.");
    }

}
