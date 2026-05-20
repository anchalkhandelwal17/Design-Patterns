package org.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Subscriber {
    void update(String s);
}

interface Channel {

    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers();
}

// Observer
class Person1 implements Subscriber {

    @Override
    public void update(String s) {
        System.out.println("Hi Person 1 " + "Abc uploaded new video, " + "Title: " + s);
    }
}

// Observer
class Person2 implements Subscriber {

    @Override
    public void update(String s) {
        System.out.println("Hi Person 2 " + "Abc uploaded new video, " + "Title: " + s);
    }
}

// Observer
class Person3 implements Subscriber {

    @Override
    public void update(String s) {
        System.out.println("Hi Person 3 " + "Abc uploaded new video, " + "Title: " + s);
    }
}

// Subject (Observable)
class YoutubeChannel implements Channel {

    private List<Subscriber> subscribers = new ArrayList<>();

    String title;

    @Override
    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers(){

        for(Subscriber subscriber : subscribers){
            subscriber.update(title);
        }
    }

    // state change method
    public void uploadNewVideo(String title){

        System.out.println(title);

        this.title = title;

        notifySubscribers();
    }
}

public class Observer {
    public static void main(String[] args) {

        YoutubeChannel channel = new YoutubeChannel();

        Person1 p1 = new Person1();
        Person2 p2 = new Person2();
        Person3 p3 = new Person3();

        channel.addSubscriber(p1);
        channel.addSubscriber(p2);
        channel.addSubscriber(p3);

        channel.uploadNewVideo("DSA");
        channel.uploadNewVideo("System Design");
    }
}
