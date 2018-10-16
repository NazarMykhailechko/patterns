package patterns.singleton;

public class TestSingleton {

    public static void main(String[] args) throws InterruptedException {

        Thread[] t = new Thread[1000];

        for (int i = 0; i <1000; i++) {

            t[i] = new Thread(Singleton::getInstance);
            t[i].start();
        }

        for (int i = 0; i <1000; i++) {
            t[i].join();
        }

        System.out.println(Singleton.counter);
    }
}

class Singleton{

    private static volatile Singleton instance;
    public static int counter;
    private Singleton() {counter++;}

    public static Singleton getInstance(){

        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}