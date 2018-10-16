package patterns.delegate;

public class TestDelegat {

    public static void main(String[] args) {
        Figure figure = new Figure(new Triangle());
        figure.print();
        figure = new Figure(new Rectangle());
        figure.print();
    }
}

interface Printer {
    void print();
}

class Triangle implements Printer {
    @Override
    public void print() {
        System.out.println("print Triangle");
    }
}

class Rectangle implements Printer {
    @Override
    public void print() {
        System.out.println("print Rectangle");
    }
}

class Figure {

    private Printer printer;

    public Figure(Printer printer) {
        this.printer = printer;
    }

    public void print() {
        printer.print();
    }
}