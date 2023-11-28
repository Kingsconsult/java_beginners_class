public class Shape {

    private int noOfSides;
    private double area;
    private String name;

    public Shape(int noOfSides, double area, String name) {
        this.noOfSides = noOfSides;
        this.area = area;
        this.name = name;
    }

    public int getNoOfSides() {
        return noOfSides;
    }

    public double getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public void setNoOfSides(int noOfSides) {
        this.noOfSides = noOfSides;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Number of sides: " + noOfSides);
        System.out.println("Area: " + area);
    }

    public static void main(String[] args) {

        Shape triangle = new Shape(3, 25.0, "Triangle");
        triangle.displayInfo();
    }

}
