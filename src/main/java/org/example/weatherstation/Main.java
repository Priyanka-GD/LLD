package org.example.weatherstation;
public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        ConcreteSubscriber thermostat = new ConcreteSubscriber();

        station.attach(thermostat);

        for (int i = 1; i <= 25; i++) {
            station.setTemperature(i * 2);
        }
    }
}
