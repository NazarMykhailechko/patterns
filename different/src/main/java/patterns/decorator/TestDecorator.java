package patterns.decorator;

public class TestDecorator {

    public static void main(String[] args) {
        Decorator decorator = new QuotedDecorator(new BracketDecorator(new Print("Hello")));
        decorator.print();
    }

}

interface Printer{
    void print();
}

class Print implements Printer{

    private String str;

    public Print(String str) {
        this.str = str;
    }

    @Override
    public void print() {
        System.out.print(str);
    }
}

abstract class Decorator implements Printer{

    Printer printer;

    public Decorator(Printer printer) {
        this.printer = printer;
    }
}


class BracketDecorator extends Decorator{

    public BracketDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print() {
        System.out.print("[");
        printer.print();
        System.out.print("]");
    }

}

class QuotedDecorator extends Decorator{

    public QuotedDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print() {
        System.out.print("\"");
        printer.print();
        System.out.print("\"");
    }
}