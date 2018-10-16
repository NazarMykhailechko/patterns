package patterns.template;

public class TestTemplate {

    public static void main(String[] args) {
        Figure triangle = new Triangle();
        Figure rectangle = new Rectangle();
        triangle.print();
        rectangle.print();
    }

}

abstract class Figure{

    abstract void draw();
    abstract void draw2();

    public void print(){
        System.out.println("***************************");
        draw();
        System.out.println("***************************");
        draw2();
    }
}

class Triangle extends Figure{

    @Override
    void draw() {
        System.out.println("draw Triangle...");
    }

    @Override
    void draw2() {
        System.out.println("Triangle square is ...");
    }
}

class Rectangle extends Figure{

    @Override
    void draw() {
        System.out.println("draw Rectangle...");
    }

    @Override
    void draw2() {

    }
}