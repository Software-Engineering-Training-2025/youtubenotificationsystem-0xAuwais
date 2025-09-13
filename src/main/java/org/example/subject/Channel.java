package org.example.subject;

import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Channel implements Subject{
    private final String name;
    private String messege;
    List<Observer> observers= Collections.synchronizedList(new ArrayList<Observer>());
    public Channel(String name) {
        this.name = name;
    }

    public void uploadVideo(String title){

        this.messege=title;
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        if(observers.contains(observer))
        observers.remove(observer);
        else{
            System.out.println("Observer Not Found");
        }
    }

    @Override
    public void notifyObservers(String message) {
        this.messege=message;
        for(Observer observer:observers){
            observer.update(message);
        }
    }

    public String getName() {
        return name;
    }
}
