package lab.paint;

import java.util.ArrayList;

/**
 * Software management system.
 */
public class Paint {
    private final ArrayList<Circle> circles = new ArrayList<>();
    private final ArrayList<Triangle> triangles = new ArrayList<>();
    private final ArrayList<Rectangle> rectangles = new ArrayList<>();

    /**
     * Gets circles.
     *
     * @return the circles
     */
    public ArrayList<Circle> getCircles() {
        return circles;
    }

    /**
     * Gets triangles.
     *
     * @return the triangles
     */
    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    /**
     * Gets rectangles.
     *
     * @return the rectangles
     */
    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }

    /**
     * Add triangle.
     *
     * @param triangle the triangle
     */
    public void addTriangle(Triangle triangle) {
        this.triangles.add(triangle);
    }

    /**
     * Add rectangle.
     *
     * @param rectangle the rectangle
     */
    public void addRectangle(Rectangle rectangle) {
        this.rectangles.add(rectangle);
    }

    /**
     * Add circle.
     *
     * @param circle the circle
     */
    public void addCircle(Circle circle) {
        this.circles.add(circle);
    }

    /**
     * Draw all.
     */
    public void drawAll() {
        for (Circle circle : this.circles) {
            System.out.println("-----------------------");
            circle.draw();
            System.out.println("-----------------------");
        }

        for (Rectangle rectangle : this.rectangles) {
            System.out.println("-----------------------");
            rectangle.draw();
            System.out.println("-----------------------");
        }

        for (Triangle triangle : this.triangles) {
            System.out.println("-----------------------");
            triangle.draw();
            System.out.println("-----------------------");
        }
    }

    /**
     * Print all.
     */
    public void printAll() {
        for (Circle circle : this.circles) {
            System.out.println("-----------------------");
            System.out.println(circle);
            System.out.println("-----------------------");
        }

        for (Rectangle rectangle : this.rectangles) {
            System.out.println("-----------------------");
            System.out.println(rectangle);
            System.out.println("-----------------------");
        }

        for (Triangle triangle : this.triangles) {
            System.out.println("-----------------------");
            System.out.println(triangle);
            System.out.println("-----------------------");
        }
    }
}

