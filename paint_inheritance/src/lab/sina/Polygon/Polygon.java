package lab.sina.Polygon;

import lab.sina.Shape;

import java.util.ArrayList;

/**
 * The type Polygon.
 */
public abstract class Polygon extends Shape {
    private final ArrayList<Double> sides;

    /**
     * Instantiates a new Polygon.
     *
     * @param sides the sides
     */
    public Polygon(ArrayList<Double> sides) {
        this.sides = sides;
    }

    /**
     * Instantiates a new Polygon.
     *
     * @param sides the sides
     */
    public Polygon(String... sides) {
        this.sides = new ArrayList<>();

        for (String sideString : sides) {
            this.sides.add(Double.parseDouble(sideString));
        }
    }

    @Override
    public double calculatePerimeter() {
        return this.sides.stream()
                .mapToDouble(side -> side)
                .sum();
    }

    /**
     * Get polygon sides
     *
     * @return the sides
     */
    public ArrayList<Double> getSides() {
        return sides;
    }
}
