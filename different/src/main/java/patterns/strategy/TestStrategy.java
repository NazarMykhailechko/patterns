package patterns.strategy;

public class TestStrategy {

    public static void main(String[] args) {
        Calc calc = new Calc(new Sum());
        System.out.println(calc.calculation(100,10));

        calc = new Calc(new Div());
        System.out.println(calc.calculation(100,10));

        calc = new Calc(new Plus());
        System.out.println(calc.calculation(100,10));

        calc = new Calc(new Minus());
        System.out.println(calc.calculation(100,10));
    }
}

class Calc{
    private Operation operation;

    public Calc(Operation operation) {
        this.operation = operation;
    }

    public int calculation(int x, int y){
        return operation.doOperation(x,y);
    }
}

interface Operation{
    int doOperation(int x,int y);
}

class Sum implements Operation{
    @Override
    public int doOperation(int x, int y) {
        return x*y;
    }
}

class Div implements Operation{
    @Override
    public int doOperation(int x, int y) {
        return x/y;
    }
}

class Plus implements Operation{
    @Override
    public int doOperation(int x, int y) {
        return x+y;
    }
}

class Minus implements Operation{
    @Override
    public int doOperation(int x, int y) {
        return x-y;
    }
}