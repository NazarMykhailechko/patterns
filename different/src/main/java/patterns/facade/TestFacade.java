package patterns.facade;

public class TestFacade {

    public static void main(String[] args) {
        Picture picture = new Picture();
        picture.drawTriangle();
        picture.drawRectangle();
        picture.drawCircle();
    }
}

class Triangle {
    void drawTriangle() {
        System.out.println("triangle");
    }
}

class Rectangle {
    void drawRectangle() {
        System.out.println("rectangle");
    }
}

class Circle {
    void drawCircle() {
        System.out.println("circle");
    }
}

class Picture {

    private Triangle triangle;
    private Rectangle rectangle;
    private Circle circle;

    public Picture() {
        triangle = new Triangle();
        rectangle = new Rectangle();
        circle = new Circle();
    }

    public void drawTriangle() {
        triangle.drawTriangle();
    }

    public void drawRectangle() {
        rectangle.drawRectangle();
    }

    public void drawCircle() {
        circle.drawCircle();
    }
}