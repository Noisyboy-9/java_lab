package lab.sina.Polygon;

import java.util.ArrayList;

/**
 * The type Triangle.
 */
public class Triangle extends Polygon {
    /**
     * Instantiates a new Triangle.
     *
     * @param sides the sides
     */
    public Triangle(ArrayList<Double> sides) {
        super(sides);
    }

    /**
     * Instantiates a new Triangle.
     *
     * @param sides the sides
     */
    public Triangle(String... sides) {
        super(sides);
    }

    @Override
    public double calculateArea() {
//        using the heron's rule for calculating perimeter
        double p = this.calculatePerimeter() / 2;

        return Math.sqrt(
                p * (p - super.getSides().get(0))
                        + p * (p - super.getSides().get(1))
                        + p * (p - super.getSides().get(2))
        );
    }

    @Override
    public void draw() {
        System.out.println("----------------------------------");
        System.out.println("Triangle");
        System.out.println("side1: " + super.getSides().get(0));
        System.out.println("side2: " + super.getSides().get(1));
        System.out.println("side3: " + super.getSides().get(2));
        System.out.println("is equilateral: " + this.isEquilateral());
        System.out.println("----------------------------------");
    }

    @Override
    public String toString() {
        return "Triangle with side1 = " + this.getSides().get(0) + " side2 = " + this.getSides().get(1) + " side 3 " + this.getSides().get(2);
    }

    /**
     * Is triangle equilateral.
     *
     * @return the boolean
     */
    public boolean isEquilateral() {
        double side1 = super.getSides().get(0);
        double side2 = super.getSides().get(1);
        double side3 = super.getSides().get(2);

        return (side1 == side2) && (side2 == side3);
    }
}

