package patterns.factory;

public class TestFactory {

    public static void main(String[] args) throws Exception {

        Figure triangle = new FigureFactory().create("Triangle");
        triangle.draw();
        Figure rectangle = new FigureFactory().create("ReCtaNgle");
        rectangle.draw();
    }

}

interface Figure{
    void draw();
}

class Triangle implements Figure{

    @Override
    public void draw() {
        System.out.println("Draw triangle...");
    }
}

class Rectangle implements Figure{

    @Override
    public void draw() {
        System.out.println("Draw rectangle...");
    }
}

class FigureFactory{

    public Figure create(String figureName) throws Exception {
        Figure figure;
        if(figureName.equalsIgnoreCase("triangle")){
            figure = new Triangle();
        }else if(figureName.equalsIgnoreCase("rectangle")){
            figure = new Rectangle();
        }else{
            throw new Exception("wrong figure name");
        }
        return figure;
    }
}