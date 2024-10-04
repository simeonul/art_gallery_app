package models.services;

import controllers.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    protected List<Observer> observerList = new ArrayList<>();

    public void add(Observer observer){
        this.observerList.add(observer);
    }

    public void remove(Observer observer){
        this.observerList.remove(observer);
    }

    public void update() {
        for(Observer observer : this.observerList){
            observer.update(this);
        }
    }
}
