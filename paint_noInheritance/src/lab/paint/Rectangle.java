package lab.paint;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The type Rectangle.
 */
public class Rectangle {
    private final ArrayList<Double> sides = new ArrayList<>();

    /**
     * Instantiates a new Rectangle.
     *
     * @param width  the width
     * @param height the height
     */
    public Rectangle(Double width, Double height) {
        this.sides.add(width);
        this.sides.add(height);
    }

    /**
     * Gets all sides as a ArrayList.
     *
     * @return the sides
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     * Check if the rectangle is a square.
     *
     * @return the boolean
     */
    public boolean isSquare() {
        double width = this.sides.get(0);
        double height = this.sides.get(1);

        return height == width;
    }

    /**
     * Calculate rectangle perimeter.
     *
     * @return the double
     */
    public double calculatePerimeter() {
        double width = this.sides.get(0);
        double height = this.sides.get(1);

        return 2 * (width + height);
    }

    /**
     * Calculate rectangle area.
     *
     * @return the double
     */
    public double calculateArea() {
        double width = this.sides.get(0);
        double height = this.sides.get(1);

        return width * height;
    }

    /**
     * Draw.
     */
    public void draw() {
        System.out.println("Rectangle");
        System.out.println("width: " + this.sides.get(0));
        System.out.println("height: " + this.sides.get(1));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return sides.equals(rectangle.sides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sides);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sides=" + sides.toString() +
                '}';
    }
}
