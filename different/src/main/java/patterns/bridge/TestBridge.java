package patterns.bridge;

public class TestBridge {

    public static void main(String[] args) {

        Figure triangle = new Triangle(new Green());
        Figure rectangle = new Rectangle(new Red());

        triangle.printFigure();
        rectangle.printFigure();

    }

}

abstract class Figure{
    Color color;
    public Figure(Color color) {
        this.color = color;
    }
    abstract void printFigure();

}

class Rectangle extends Figure{

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void printFigure() {
        System.out.println("Triangle");
        color.fill();
    }
}

class Triangle extends Figure{

    public Triangle(Color color) {
        super(color);
    }

    @Override
    void printFigure() {
        System.out.println("Rectangle");
        color.fill();
    }
}

interface Color{
    void fill();
}

class Green implements Color{

    @Override
    public void fill() {
        System.out.println("Green");
    }
}

class Red implements Color{

    @Override
    public void fill() {
        System.out.println("Red");
    }
}

