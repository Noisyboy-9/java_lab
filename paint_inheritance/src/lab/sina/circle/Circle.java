package lab.sina.circle;

import lab.sina.Shape;

import java.util.Objects;

/**
 * The type Circle.
 */
public class Circle extends Shape {
    private final double radius;

    /**
     * Instantiates a new Circle.
     *
     * @param radius the radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double calculateArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    @Override
    public void draw() {
        System.out.println("----------------------------------");
        System.out.println("Circle");
        System.out.println("radius: " + this.radius);
        System.out.println("perimeter: " + this.calculatePerimeter());
        System.out.println("area: " + this.calculateArea());
        System.out.println("----------------------------------");
    }

    @Override
    public String toString() {
        return "Circle with radius = " + this.radius;
    }

    /**
     * Gets radius.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Circle circle = (Circle) object;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

