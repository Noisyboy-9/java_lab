package lab.sina;

/**
 * The Abstract type shape.
 */
public abstract class Shape {
    /**
     * Calculate perimeter of the shape.
     *
     * @return the double
     */
    public abstract double calculatePerimeter();

    /**
     * Calculate area of the shape.
     *
     * @return the double
     */
    public abstract double calculateArea();

    /**
     * Print all data related to the shape.
     */
    public abstract void draw();
}
