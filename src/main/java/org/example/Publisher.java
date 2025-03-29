package org.example;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    List<Subscriber> subscriberList = new ArrayList<>();

    public void attach(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    public void detach(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : subscriberList) {
            subscriber.update(this);
        }
    }

}
