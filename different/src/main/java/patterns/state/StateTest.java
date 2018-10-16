package patterns.state;

public class StateTest {
    public static void main(String[] args) {

        Radio radio = new Radio(new RadioRockFM());

        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }

    }
}

interface Station{
    void play();
}

class RadioRockFM implements Station{

    @Override
    public void play() {
        System.out.println("RockFM is playing...");
    }
}

class RadioUkraineFM implements Station{

    @Override
    public void play() {
        System.out.println("UkraineFM is playing...");
    }
}

class RadioHitFM implements Station{

    @Override
    public void play() {
        System.out.println("HitFM is playing...");
    }
}

class Radio implements Station{
    private Station station;

    public Radio(Station station) {
        this.station = station;
    }

    public Station getStation() {
        return station;
    }

    public void nextStation(){
        if(station instanceof RadioRockFM){
            station = new RadioUkraineFM();
        }else if(station instanceof RadioUkraineFM){
            station = new RadioHitFM();
        }else if(station instanceof RadioHitFM){
            station = new RadioRockFM();
        }
    }

    @Override
    public void play() {
        station.play();
    }
}