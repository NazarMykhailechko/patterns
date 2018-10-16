package patterns.command;

public class TestCommand {

    public static void main(String[] args) {

         Computer computer = new Computer();
         User user = new User(new StartCommand(computer),new StopCommand(computer),new ResetCommand(computer));

         user.start();
         user.stop();
         user.reset();
    }

}

interface Command{
    void execute();
}

class Computer{

    public void start(){
        System.out.println("Start");
    }
    public void stop(){
        System.out.println("Stop");
    }
    public void reset(){
        System.out.println("Reset");
    }

}
class StartCommand implements Command{

    private Computer computer;

    public StartCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}

class StopCommand implements Command{

    private Computer computer;

    public StopCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}

class ResetCommand implements Command{

    private Computer computer;

    public ResetCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

class User{
    private Command start;
    private Command stop;
    private Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    public void start(){
        start.execute();
    }
    public void stop(){
        stop.execute();
    }
    public void reset(){
        reset.execute();
    }
}