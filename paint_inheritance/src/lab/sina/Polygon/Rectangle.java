package lab.sina.Polygon;

import lab.sina.circle.Circle;

import java.util.ArrayList;

/**
 * The type Rectangle.
 */
public class Rectangle extends Polygon {

    /**
     * Instantiates a new Rectangle.
     *
     * @param sides the sides
     */
    public Rectangle(ArrayList<Double> sides) {
        super(sides);
    }

    /**
     * Instantiates a new Rectangle.
     *
     * @param sides the sides
     */
    public Rectangle(String... sides) {
        super(sides);
    }


    @Override
    public double calculateArea() {
        double side1 = super.getSides().get(0);
        double side2 = super.getSides().get(1);

        return side1 * side2;
    }

    @Override
    public void draw() {
        System.out.println("----------------------------------");
        System.out.println("Rectangle");
        System.out.println("width:  " + super.getSides().get(0));
        System.out.println("height: " + super.getSides().get(1));
        System.out.println("perimeter: " + this.calculatePerimeter());
        System.out.println("area: " + this.calculateArea());
        System.out.println("is square : " + this.isSquare());
        System.out.println("----------------------------------");
    }

    /**
     * Is rectangle width and height equal.
     *
     * @return the boolean
     */
    public boolean isSquare() {
        double side1 = super.getSides().get(0);
        double side2 = super.getSides().get(1);

        return side1 == side2;
    }

    @Override
    public String toString() {
        return "Rectangle with " + "height = " + super.getSides().get(0) + " width = " + super.getSides().get(1);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Rectangle rectangle = (Rectangle) object;
        return this.getSides().equals(rectangle.getSides());
    }
}
