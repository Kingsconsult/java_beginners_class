public class ClassWork {

    public static void main(String[] args) {

        Circle circle = new Circle();
        Square square = new Square();

        circle.area();
        square.area();
    }
}

class Shape {
    int noOfSides;
    String name;

    public void area() {
        System.out.println("this is area from the parent class");
    }

    public int getNoOfSides() {
        return noOfSides;
    }

    public void setNoOfSides(int noOfSides) {
        this.noOfSides = noOfSides;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Circle extends Shape {
    public void area() {
        System.out.println("this is area from the child class");
    }
}

class Square extends Shape {

}