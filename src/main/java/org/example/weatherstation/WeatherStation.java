package org.example.weatherstation;

public class WeatherStation extends Publisher {
    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        notifySubscribers();
    }
}
