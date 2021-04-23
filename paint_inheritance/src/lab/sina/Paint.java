package lab.sina;

import java.util.ArrayList;

/**
 * The paint for managing the software.
 */
public class Paint {
    private final ArrayList<Shape> shapes = new ArrayList<>();

    /**
     * Add shape.
     *
     * @param shape the shape
     */
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    /**
     * Print all data about all shapes.
     */
    public void drawAll() {
        for (Shape shape : this.shapes) {
            shape.draw();
        }
    }

    /**
     * Print minimal data about every shape.
     */
    public void printAll() {
        for (Shape shape : this.shapes) {
            System.out.println(shape);
        }
    }
}

