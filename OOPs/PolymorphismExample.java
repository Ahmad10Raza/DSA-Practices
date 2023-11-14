// Base class or interface
interface Shape {
    double calculateArea();
    void display();
}

// Circle class implementing Shape
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("Drawing a circle");
    }
}

// Rectangle class implementing Shape
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void display() {
        System.out.println("Drawing a rectangle");
    }
}

// Usage of polymorphism
public class PolymorphismExample {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        // Process shapes uniformly
        processShape(circle);
        processShape(rectangle);
    }

    // Method for processing shapes uniformly
    public static void processShape(Shape shape) {
        shape.display();
        System.out.println("Area: " + shape.calculateArea());
    }
}
