package lab.sina;

import lab.sina.Polygon.Triangle;
import lab.sina.circle.Circle;
import lab.sina.Polygon.Rectangle;

public class Main {
    public static void main(String[] args) {
        Paint paint = new Paint();

        Circle circle1 = new Circle(19.0);
        Circle circle2 = new Circle(3.0);
        paint.addShape(circle1);
        paint.addShape(circle2);


        Rectangle rectangle1 = new Rectangle("10.0", "12.0", "10.0", "12.0");
        Rectangle rectangle2 = new Rectangle("8.0", "5.0", "8.0", "5.0");
        Rectangle rectangle3 = new Rectangle("6.0", "6.0", "6.0", "6.0");
        paint.addShape(rectangle1);
        paint.addShape(rectangle2);
        paint.addShape(rectangle3);

        Triangle triangle1 = new Triangle("2.0", "2.0", "2.0");
        Triangle triangle2 = new Triangle("4.0", "6.0", "5.0");
        paint.addShape(triangle1);
        paint.addShape(triangle2);

        paint.drawAll();
        paint.printAll();
    }
}
