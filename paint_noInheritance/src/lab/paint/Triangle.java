package lab.paint;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The type Triangle.
 */
public class Triangle {
    private final ArrayList<Double> sides = new ArrayList<>();

    /**
     * Instantiates a new Triangle.
     *
     * @param side1 the side 1
     * @param side2 the side 2
     * @param side3 the side 3
     */
    public Triangle(Double side1, Double side2, Double side3) {
        this.sides.add(side1);
        this.sides.add(side2);
        this.sides.add(side3);
    }

    /**
     * Get a array list sides.
     *
     * @return the sides
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     * Check if the triangle is equilateral.
     *
     * @return the boolean
     */
    public boolean isEquilateral() {
        Double side1 = this.sides.get(0);
        Double side2 = this.sides.get(1);
        Double side3 = this.sides.get(2);

        return (side1 == side2) && (side2 == side3);
    }

    /**
     * Calculate perimeter of the triangle.
     *
     * @return the double
     */
    public double calculatePerimeter() {
        return this.sides.stream().mapToDouble(side -> side).sum();
    }

    /**
     * Calculate area of the triangle.
     *
     * @return the double
     */
    public double calculateArea() {
//        using heron's formula we can calculate area of the triangle from its sides.
        double p = this.calculatePerimeter() / 2;
        return Math.sqrt(
                p * (p - this.sides.get(0)) + p * (p - this.sides.get(1)) + p * (p - this.sides.get(2))
        );
    }

    /**
     * Print type and all sides of the triangle.
     */
    public void draw() {
        System.out.println("Triangle");
        System.out.println("side1 : " + this.sides.get(0));
        System.out.println("side2 : " + this.sides.get(1));
        System.out.println("side3 : " + this.sides.get(2));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Triangle triangle = (Triangle) object;
        return Objects.equals(sides, triangle.sides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sides);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sides=" + sides.toString() +
                '}';
    }

}
