package patterns.chainOfResponsibility;

public class TestChainOfResponsibility {

    public static void main(String[] args) {

        Logger logger = new SmsLogger(Logger.ERROR);
        Logger logger1 = new FileLogger(Logger.ERROR);
        Logger logger2 = new EmailLogger(Logger.INFO);

        logger.setLogger(logger1);
        logger1.setLogger(logger2);

        logger.printMassage(Logger.ERROR,"Huston, we had a problem!!!");
        logger.printMassage(Logger.INFO,"We are working on it!!!");
        logger.printMassage(Logger.DEBUG,"Now is Debug mode!!!");
        logger.printMassage(Logger.TRACE,"Now is Trace mode!!!");

    }
}

abstract class Logger{

    static final int ERROR = 4;
    static final int INFO = 3;
    static final int DEBUG = 2;
    static final int TRACE = 1;

    private Logger nextLogger;

    private int level;

    public Logger(int level) {
        this.level = level;
    }

    public void printMassage(int level, String massage){

        if(this.level<=level){
            massage(massage);
        }
        if(nextLogger!=null){
            nextLogger.printMassage(level,massage);
        }
    }

    public void setLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    abstract void massage(String massage);
}

class SmsLogger extends Logger{

    public SmsLogger(int level) {
        super(level);
    }

    @Override
    void massage(String massage) {
        System.out.println("SmsLogger: " + massage);
    }

}

class FileLogger extends Logger{

    public FileLogger(int level) {
        super(level);
    }

    @Override
    void massage(String massage) {
        System.out.println("FileLogger: " + massage);
    }
}

class EmailLogger extends Logger{

    public EmailLogger(int level) {
        super(level);
    }

    @Override
    void massage(String massage) {
        System.out.println("EmailLogger: " + massage);
    }
}