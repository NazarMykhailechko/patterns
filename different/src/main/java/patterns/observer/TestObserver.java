package patterns.observer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestObserver {

    public static void main(String[] args) {
        MeteoStation meteoStation = new MeteoStation();

        meteoStation.add(new ConsoleObserver());
        meteoStation.add(new FileObserver());

        meteoStation.setState(19,255);
        meteoStation.setState(25,199);
        meteoStation.setState(21,155);

    }

}

interface Observable{
    void add(Observer observer);
    void remove(Observer observer);
    void notifyObservers();
}

interface Observer{
    void event(int temperature, int pressure) throws IOException;
}

class MeteoStation implements Observable{

    private int temperature;
    private int pressure;

    private List<Observer> observerList = new ArrayList<>();

    public void setState(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
         observerList.forEach((o) -> {
             try {
                 o.event(temperature, pressure);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         });
    }
}

class ConsoleObserver implements Observer{
    @Override
    public void event(int temperature, int pressure) {
        System.out.println("The weather is changed: temperature is: " + temperature + " pressure is : " + pressure);
    }
}
class FileObserver implements Observer{
    @Override
    public void event(int temperature, int pressure) {

        try(FileWriter fr = new FileWriter("different/src/main/java/patterns/observer/weather.txt",true)) {
            fr.write("The weather is changed: temperature is: " + temperature + " pressure is : " + pressure + "\n");
            fr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}