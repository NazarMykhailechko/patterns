package patterns.factoryAbstract;

public class TestAbstractFactory {

    public static void main(String[] args) throws Exception {

        AbstractFactory abstractFactory = FactoryProducer.getFactory("Figure");
        Figure triangle = abstractFactory.getFigure("Rectangle");
        triangle.draw();
        abstractFactory = FactoryProducer.getFactory("Color");
        Color green = abstractFactory.getColor("Red");
        green.fill();

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

interface Color{
    void fill();
}

class Red implements Color{

    @Override
    public void fill() {
        System.out.println("fill red color...");
    }
}

class Green implements Color{

    @Override
    public void fill() {
        System.out.println("fill green color...");
    }
}

abstract class AbstractFactory{
    abstract Figure getFigure(String figureName) throws Exception;
    abstract Color getColor(String colorName) throws Exception;
}

class FigureFactory extends AbstractFactory{

    @Override
    Figure getFigure(String figureName) throws Exception {
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

    @Override
    Color getColor(String colorName) {
        return null;
    }
}

class ColorFactory extends AbstractFactory{

    @Override
    Figure getFigure(String figureName) throws Exception {
        return null;
    }

    @Override
    Color getColor(String colorName) throws Exception {
        Color color;
        if(colorName.equalsIgnoreCase("red")){
            color = new Red();
        }else if(colorName.equalsIgnoreCase("green")){
            color = new Green();
        }else{
            throw new Exception("wrong color name");
        }
        return color;
    }
}

class FactoryProducer{
    public static AbstractFactory getFactory(String choice) throws Exception {
        AbstractFactory abstractFactory;
        if(choice.equalsIgnoreCase("Figure")){
            abstractFactory = new FigureFactory();
        }else if(choice.equalsIgnoreCase("Color")){
            abstractFactory = new ColorFactory();
        }else{
            throw new Exception("wrong choice");
        }
        return abstractFactory;
    }
}