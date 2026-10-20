package mod3;



abstract class Shape {
    abstract void numberOfSides();

    void sumOfAngles(int sides) {
        int sum = (sides - 2) * 180;
        System.out.println("Sum of interior angles: " + sum);
    }
}

class Rectangle extends Shape {
    void numberOfSides() {
        System.out.println("Rectangle has 4 sides.");
        sumOfAngles(4);
    }
}

class Triangle extends Shape {
    void numberOfSides() {
        System.out.println("Triangle has 3 sides.");
        sumOfAngles(3);
    }
}

class Hexagon extends Shape {
    void numberOfSides() {
        System.out.println("Hexagon has 6 sides.");
        sumOfAngles(6);
    }
}

public class program1 {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();
        Shape hexagon = new Hexagon();

        rectangle.numberOfSides();
        System.out.println();

        triangle.numberOfSides();
        System.out.println();

        hexagon.numberOfSides();
    }
}
