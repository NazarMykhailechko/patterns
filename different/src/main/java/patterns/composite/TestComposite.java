package patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class TestComposite {

    public static void main(String[] args) {
        Composite compositeRoot = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        Figure triangle = new Triangle(2,3);
        Figure triangle1 = new Triangle(3,4);
        Figure triangle2 = new Triangle(6,10);
        Figure triangle3 = new Triangle(5,9);

        Figure rectangle = new Rectangle(10,20);
        Figure rectangle1 = new Rectangle(34,40);
        Figure rectangle2 = new Rectangle(56,88);
        Figure rectangle3 = new Rectangle(23,10);
        Figure rectangle4 = new Rectangle(11,24);
        Figure rectangle5 = new Rectangle(68,30);

        compositeRoot.addFigure(composite1);
        compositeRoot.addFigure(composite2);
        compositeRoot.addFigure(new Circle(55));

        composite1.addFigure(triangle);
        composite1.addFigure(triangle3);
        composite1.addFigure(rectangle1);
        composite1.addFigure(rectangle4);
        composite1.addFigure(rectangle5);

        composite2.addFigure(triangle1);
        composite2.addFigure(triangle2);
        composite2.addFigure(rectangle);
        composite2.addFigure(rectangle2);
        composite2.addFigure(rectangle3);

        compositeRoot.draw();

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

    abstract void draw();

    @Override
    public String toString() {
        return "Figure{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}

class Triangle extends Figure{

    public Triangle(double width, double height) {
        super(width, height);
    }

    @Override
    void draw() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                '}';
    }
}

class Rectangle extends Figure{

    public Rectangle(double width, double height) {
        super(width, height);
    }

    @Override
    void draw() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                '}';
    }
}

class Circle extends Figure{

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}

class Composite extends Figure{

    List<Figure> figures = new ArrayList<>();

    public void addFigure(Figure figure){
        figures.add(figure);
    }

    public void removeFigure(Figure figure){
        figures.remove(figure);
    }

    @Override
    void draw() {
        figures.stream().forEach(Figure::draw);
    }
}