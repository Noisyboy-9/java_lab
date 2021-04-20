package lab.paint;

public class Main {

    public static void main(String[] args) {
        Circle circle1 = new Circle(19.0);
        Circle circle2 = new Circle(3.0);

        Rectangle rectangle1 = new Rectangle(1.0, 4.0);
        Rectangle rectangle2 = new Rectangle(8.0, 5.0);
        Rectangle rectangle3 = new Rectangle(6.0, 6.0);

        Triangle triangle1 = new Triangle(2.0, 2.0, 2.0);
        Triangle triangle2 = new Triangle(4.0, 4.0, 6.0);

        Paint paint = new Paint();

        paint.addCircle(circle1);
        paint.addCircle(circle2);

        paint.addRectangle(rectangle1);
        paint.addRectangle(rectangle2);
        paint.addRectangle(rectangle3);

        paint.addTriangle(triangle1);
        paint.addTriangle(triangle2);

        paint.drawAll();
        paint.printAll();
    }
}
