package patterns.adapter;

public class TestAdapter {

    public static void main(String[] args) {
        Figure triangle = new Triangle(3.0,4.0);
        Figure rectangle = new Rectangle(3.0,4.0);
        Figure circle = new CircleAdapter(new Circle(25.0));

        System.out.println(triangle.square());
        System.out.println(rectangle.square());
        System.out.println(circle.square());
    }

}

abstract class Figure{

    private double width;
    private double height;

    public Figure() {
    }

    public Figure(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    abstract double square();

}

class Triangle extends Figure{

    public Triangle(double width, double height) {
        super(width, height);
    }

    @Override
    double square() {
        return getWidth()*getHeight()*0.5;
    }
}

class Rectangle extends Figure{

    public Rectangle(double width, double height) {
        super(width, height);
    }

    @Override
    double square() {
        return getWidth()*getHeight();
    }
}

class Circle extends Thread{

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double square() {
        return Math.PI*Math.pow(radius,2);
    }
}

class CircleAdapter extends Figure{

    private Circle circle;

    public CircleAdapter(Circle circle) {
        this.circle = circle;
    }

    @Override
    double square() {
        return circle.square();
    }
}