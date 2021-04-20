package lab.paint;

import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

/**
 * The type Circle.
 */
public class Circle {
    private final double radius;

    /**
     * Instantiates a new Circle.
     *
     * @param radius the radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Gets radius of the circle.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Calculate circle perimeter.
     *
     * @return the double
     */
    public double calculatePerimeter() {
        return 2 * this.radius * Math.PI;
    }

    /**
     * Calculate circle area.
     *
     * @return the double
     */
    public double calculateArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    /**
     * Print out radius, perimeter, area of the circle.
     */
    public void draw() {
        System.out.println("Circle");
        System.out.println("radius: " + this.radius);
        System.out.println("area: " + this.calculateArea());
        System.out.println("perimeter: " + this.calculatePerimeter());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Circle circle = (Circle) object;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
