package patterns.flyweight;

import java.util.*;

public class TestFlyweight {

    public static void main(String[] args) throws Exception {

        FlyWeightFactory flyWeightFactory = new FlyWeightFactory();

        List<Figure> figures = new ArrayList<>();

        figures.add(flyWeightFactory.getFigure("triangle"));
        figures.add(flyWeightFactory.getFigure("rectangle"));
        figures.add(flyWeightFactory.getFigure("triangle"));
        figures.add(flyWeightFactory.getFigure("triangle"));
        figures.add(flyWeightFactory.getFigure("square"));
        figures.add(flyWeightFactory.getFigure("square"));
        figures.add(flyWeightFactory.getFigure("triangle"));
        figures.add(flyWeightFactory.getFigure("rectangle"));
        figures.add(flyWeightFactory.getFigure("triangle"));

        Random random = new Random();
        figures.stream().forEach((f)->f.draw(random.nextInt(10),random.nextInt(10)));

    }

}

abstract class Figure {
    public abstract void draw(int width, int height);
}

class Triangle extends Figure {
    @Override
    public void draw(int width, int height) {
        System.out.println("Draw triangle: " + width + "-" + height);
    }
}

class Rectangle extends Figure {
    @Override
    public void draw(int width, int height) {
        System.out.println("Draw rectangle: " + width + "-" + height);
    }
}

class Square extends Figure {
    @Override
    public void draw(int width, int height) {
        System.out.println("Draw square: " + width + "-" + height);
    }
}

class FlyWeightFactory {

    private Map<String, Figure> figureMap = new HashMap<>();

    public Figure getFigure(String figureName) throws Exception {

        Figure figure = figureMap.get(figureName);
        if (figure == null) {
            if (figureName.equalsIgnoreCase("triangle")) {
                figure = new Triangle();
            } else if (figureName.equalsIgnoreCase("rectangle")) {
                figure = new Rectangle();
            } else if (figureName.equalsIgnoreCase("square")) {
                figure = new Square();
            } else {
                throw new Exception("unknown figure!!!");
            }
            figureMap.put(figureName, figure);
        }

        return figure;

    }
}