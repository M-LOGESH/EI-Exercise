// ObserverPattern.java
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int temperature);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

class TemperatureDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Temperature updated to: " + temperature);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Subject weatherStation = new Subject();
        TemperatureDisplay display = new TemperatureDisplay();

        weatherStation.addObserver(display);
        weatherStation.setTemperature(25);
        weatherStation.setTemperature(30);
    }
}
