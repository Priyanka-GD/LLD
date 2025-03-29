package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ConcreteSubscriber implements Subscriber {

    private final Queue<Integer> temperatures = new LinkedList<>();
    private static final int MAX_ENTRIES = 24;

    @Override
    public void update(Publisher publisher) {
        if (publisher instanceof WeatherStation) {
            int newTemp = ((WeatherStation) publisher).getTemperature();
            if (temperatures.size() == MAX_ENTRIES) {
                temperatures.poll();
            }
            temperatures.offer(newTemp);
            display(newTemp);
        }
    }

    public void display(int temp) {
        System.out.println("New temperature: " + temp);
        System.out.println("Average (last 24 readings): " + getAverage());
    }

    private double getAverage() {
        if (temperatures.isEmpty())
            return 0;
        int sum = 0;
        for (int t : temperatures) {
            sum += t;
        }
        return (double) sum / temperatures.size();
    }
}
